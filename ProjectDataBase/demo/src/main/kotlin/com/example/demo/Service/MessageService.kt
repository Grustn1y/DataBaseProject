package com.example.demo.Service

import com.example.demo.Models.Message
import com.example.demo.Repositories.MessageRepository
import org.springframework.stereotype.Service

@Service
 class MessageService(private val messageProductRepository: MessageRepository)
{
    fun all():List<Message> = messageProductRepository.findAll()

    fun get(id:Long): Message
    {
        val info=messageProductRepository.findById(id)

        if (info.isPresent)
        {
            return info.get()
        }
        else
            throw RuntimeException("Не сущестувует")
    }

    fun add(product: Message): Message
    {
        val new:Message = Message(appealId = product.appealId, ownerId = product.ownerId, header = product.header, content = product.content, dateOfCreate = product.dateOfCreate)

        return messageProductRepository.save(new)
    }
    fun edit(id: Long,product:Message): Message =messageProductRepository.save(product.copy(id=id))

    fun remove(id: Message)
    {
        messageProductRepository.delete(id)
    }
 }