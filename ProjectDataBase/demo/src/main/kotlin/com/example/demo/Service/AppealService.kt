package com.example.demo.Service

import com.example.demo.Models.*
import com.example.demo.Repositories.AppealRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service

class AppealService(private val appealProductRepository:AppealRepository)
{
    fun all():List<Appeal> = appealProductRepository.findAll()

    fun get(id:Long): Appeal
    {
        val info=appealProductRepository.findById(id)

        if (info.isPresent)
        {
            return info.get()
        }
        else
            throw RuntimeException("Не сущестувует")
    }

    fun add(product:Appeal):Appeal
    {
        val new: Appeal = Appeal(id = product.id, userId = product.userId, employeeId = product.employeeId, statusId = product.statusId, dateOfCreate = product.dateOfCreate)

      return appealProductRepository.save(new)
    }
    fun edit(id: Long,product: Appeal): Appeal =appealProductRepository.save(product.copy(id=id))

    fun remove(id: Appeal)
    {
        appealProductRepository.delete(id)
    }

    fun readAll(start:Int,end:Int):Page<Appeal> = appealProductRepository.findAll(PageRequest.of(start,end))
}