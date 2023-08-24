package com.example.demo.Service

import com.example.demo.Models.Message
import com.example.demo.Repositories.MessageRepository
import org.springframework.stereotype.Service

@Service
 class MessageService(private val messageRepository: MessageRepository)
{
    fun all():List<Message> = messageRepository.findAll()

    fun get(id:Long): Message
    {
        val info=messageRepository.findById(id)

        if (info.isPresent)
        {
            return info.get()
        }
        else
        {
            throw RuntimeException("Not exists")
        }
    }

    fun add(product: Message): Message
    {
        val new:Message = Message(
        appealId = product.appealId,
        ownerId = product.ownerId,
        appealHeader=product.appealHeader,
        content = product.content,
        dateOfCreate = product.dateOfCreate
        )

        return messageRepository.save(new)
    }

    fun remove(id: Message)
    {
        messageRepository.delete(id)
    }
 }