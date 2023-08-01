package com.example.demo.Service

import com.example.demo.Models.MessageProduct
import com.example.demo.Models.UsersProduct
import com.example.demo.Repositories.MessageProductRepository
import org.springframework.stereotype.Service

@Service
 class MessageProductService(private val messageProductRepository: MessageProductRepository)
{
    fun all():List<MessageProduct> = messageProductRepository.findAll()

    fun get(id:Long): MessageProduct
    {
        val info=messageProductRepository.findById(id)

        if (info.isPresent)
        {
            return info.get()
        }
        else
            throw RuntimeException("Не сущестувует")
    }

    fun add(product: MessageProduct): MessageProduct
    {
        val new:MessageProduct = MessageProduct(appealId = product.appealId, ownerId = product.ownerId, content = product.content, dateOfCreate = product.dateOfCreate)

        return messageProductRepository.save(new)
    }
    fun edit(id: Long,product:MessageProduct): MessageProduct =messageProductRepository.save(product.copy(id=id))

    fun remove(id: MessageProduct)
    {
        messageProductRepository.delete(id)
    }
 }