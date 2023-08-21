package com.example.demo.Service

import com.example.demo.Models.Status
import com.example.demo.Repositories.StatusRepository
import org.springframework.stereotype.Service

@Service
class StatusService (private val statusProductRepository: StatusRepository)
{
    fun all():List<Status> =statusProductRepository.findAll()

    fun get(id:Long):Status
    {
        val info=statusProductRepository.findById(id)

        if (info.isPresent)
        {
            return info.get()
        }
        else
        {
            throw RuntimeException ("Не существует")
        }
    }

    fun add(product:Status):Status
    {
        val new:Status=Status(statusAppeal =product.statusAppeal, appealId = product.appealId, dateCreate =product.dateCreate)
        return statusProductRepository.save(new)
    }

fun edit(id:Long,product: Status):Status=statusProductRepository.save(product.copy(id=id))

    fun remove(id:Status)
    {
        statusProductRepository.delete(id)
    }
}


