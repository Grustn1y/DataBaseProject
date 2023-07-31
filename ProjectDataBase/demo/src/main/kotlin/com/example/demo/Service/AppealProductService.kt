package com.example.demo.Service

import com.example.demo.Models.*
import com.example.demo.Repositories.AppealProductRepository
import org.springframework.stereotype.Service

@Service

class AppealProductService(private val appealProductRepository:AppealProductRepository)
{
    fun all():List<AppealProduct> = appealProductRepository.findAll()

    fun get(id:Long): AppealProduct
    {
        val info=appealProductRepository.findById(id)

        if (info.isPresent)
        {
            return info.get()
        }
        else
            throw RuntimeException("Не сущестувует")
    }

    fun add(product:AppealProduct):AppealProduct
    {
        val new: AppealProduct = AppealProduct(id = product.id, userId = product.userId, employeeId = product.employeeId, statusId = product.statusId, dateOfCreate = product.dateOfCreate)

      return appealProductRepository.save(new)
    }
    fun edit(id: Long,product: AppealProduct): AppealProduct =appealProductRepository.save(product.copy(id=id))

    fun remove(id: AppealProduct)
    {
        appealProductRepository.delete(id)
    }
}