package com.example.demo.Service

import com.example.demo.Models.Status
import com.example.demo.Repositories.StatusRepository
import org.springframework.stereotype.Service

@Service
class StatusService (private val statusRepository: StatusRepository)
{
    fun all():List<Status> =statusRepository.findAll()

    fun get(id:Long):Status
    {
        val info=statusRepository.findById(id)

        if (info.isPresent)
        {
            return info.get()
        }
        else
        {
            throw RuntimeException ("Not exists")
        }
    }

    fun add(product:Status):Status
    {
        val new:Status=Status(
                statusAppeal = product.statusAppeal,
                appealId = product.appealId,
                dateOfCreate =product.dateOfCreate
        )

        return statusRepository.save(new)
    }

    fun remove(id:Status)
    {
        statusRepository.delete(id)
    }
}


