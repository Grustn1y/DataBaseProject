package com.example.demo.Service

import com.example.demo.Models.*
import com.example.demo.Repositories.AppealRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service

class AppealService(private val appealRepository:AppealRepository)
{
    fun all():List<Appeal> = appealRepository.findAll()

    fun get(id:Long): Appeal
    {
        val info=appealRepository.findById(id)

        if (info.isPresent)
        {
            return info.get()
        }
        else
        {
            throw RuntimeException("Not exists")
        }
    }

    fun add(product:Appeal):Appeal
    {
        val new: Appeal = Appeal(

        id = product.id,
        userId = product.userId,
        employeeId = product.employeeId,
        statusId = product.statusId,
        dateOfCreate = product.dateOfCreate
        )

        return appealRepository.save(new)
    }

    fun remove(id: Appeal)
    {
        appealRepository.delete(id)
    }

    fun readAppealFromTo(start:Int, end:Int):Page<Appeal>
    {
       return appealRepository.findAll(PageRequest.of(start,end))
    }
}