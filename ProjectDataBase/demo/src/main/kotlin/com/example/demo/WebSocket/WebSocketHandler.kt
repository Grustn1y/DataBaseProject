package com.example.demo.WebSocket

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.coyote.Response
import org.springframework.http.converter.ObjectToStringHttpMessageConverter
import org.springframework.stereotype.Component
import java.net.http.WebSocket
import java.util.logging.Logger
    }

}
@Component
class ChatWebSocketHandler(
        val objectMapper: ObjectMapper,
        val logger: Logger,
        val sinkWrapper: SinkWrapper
) : WebSocketHandler

{


    private val userIdToSession: MutableMap<UUID, LinkedList<WebSocketSession>> = ConcurrentHashMap()

    override fun handle(session: WebSocketSession): Mono<Void> {
        return ReactiveSecurityContextHolder.getContext()
                .flatMap { ctx ->
                    val userId = UUID.fromString((ctx.authentication.details as Claims)["id"].toString())
                    val sender = getSenderStream(session, userId)
                    val receiver = getReceiverStream(session, userId)

                    return@flatMap Mono.zip(sender, receiver).then()
                }
    }

    private fun getReceiverStream(session: WebSocketSession, userId: UUID): Mono<Void> {
        return session.receive()
                .filter { it.type == WebSocketMessage.Type.TEXT }
                .map(WebSocketMessage::getPayloadAsText)
                .flatMap {
                    objectStringConverter.stringToObject(it, WebSocketEvent::class.java)
                }
                .flatMap { convertedEvent ->
                    when (convertedEvent) {
                        is NewMessageEvent -> chatService.handleNewMessageEvent(userId, convertedEvent)
                        is MarkMessageAsRead -> chatService.markPreviousMessagesAsRead(convertedEvent.messageId)
                        else -> Mono.error(RuntimeException())
                    }
                }
                .onErrorContinue { t, _ -> logger.error("Error occurred with receiver stream", t) }
                .doOnSubscribe {
                    val userSession = userIdToSession[userId]
                    if (userSession == null) {
                        val newUserSessions = LinkedList<WebSocketSession>()
                        userIdToSession[userId] = newUserSessions
                    }
                    userIdToSession[userId]?.add(session)
                }
                .doFinally {
                    val userSessions = userIdToSession[userId]
                    userSessions?.remove(session)
                }
                .then()
    }

    private fun getSenderStream(session: WebSocketSession, userId: UUID): Mono<Void> {
        val sendMessage = sinkWrapper.sinks.asFlux()
                .filter { sendTo -> sendTo.userId == userId }
                .map { sendTo -> objectMapper.writeValueAsString(sendTo.event) }
                .map { stringObject -> session.textMessage(stringObject) }
                .doOnError { logger.error("", it) }
        return session.send(sendMessage)
    }
}

@Component
class SinkWrapper {
    val sinks: Sinks.Many<SendTo> = Sinks.many().multicast().onBackpressureBuffer()
}

@Configuration
class ReactiveWebSocketConfig {

    @Bean
    fun webSocketHandlerMapping(chatWebSocketHandler: ChatWebSocketHandler): HandlerMapping {
        val map: MutableMap<String, WebSocketHandler> = HashMap()
        map["/ws/chat"] = chatWebSocketHandler

        val handlerMapping = SimpleUrlHandlerMapping()
        handlerMapping.setCorsConfigurations(Collections.singletonMap("*", CorsConfiguration().applyPermitDefaultValues()))
        handlerMapping.order = 1
        handlerMapping.urlMap = map
        return handlerMapping
    }

    @Bean
    fun handlerAdapter(): WebSocketHandlerAdapter {
        return WebSocketHandlerAdapter()
    }
}

