package com.example.demo.Service

import com.example.demo.Models.StatusProduct
import com.example.demo.Repositories.StatusProductRepository
import org.springframework.stereotype.Service
import java.lang.management.RuntimeMXBean

@Service
class StatusProductService (private val statusProductRepository: StatusProductRepository)
{
    fun all():List<StatusProduct> =statusProductRepository.findAll()

    fun get(id:Long):StatusProduct
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

    fun add(product:StatusProduct):StatusProduct
    {
        val new:StatusProduct=StatusProduct(statusAppeal =product.statusAppeal, appealId = product.appealId, dateCreate =product.dateCreate)
        return statusProductRepository.save(new)
    }

    fun remove(id:StatusProduct)
    {
        statusProductRepository.delete(id)
    }
}


