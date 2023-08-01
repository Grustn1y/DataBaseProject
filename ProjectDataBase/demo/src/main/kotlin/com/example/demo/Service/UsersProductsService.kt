package com.example.demo.Service

import com.example.demo.Repositories.UsersProductRepository
import com.example.demo.Models.*
import org.springframework.stereotype.Service

@Service

class UsersProductsService (private val usersProductRepository: UsersProductRepository)
{
    fun all():List<UsersProduct> = usersProductRepository.findAll()

    fun get(id:Long):UsersProduct
    {
        val info=usersProductRepository.findById(id)

        if (info.isPresent)
        {
            return info.get()
        }
        else
            throw RuntimeException("Не сущестувует")
    }

    fun add(product: UsersProduct):UsersProduct
    {
       val new:UsersProduct= UsersProduct(firstName = product.firstName, lastName = product.firstName, email = product.email, password = product.password, thirdName = product.thirdName, address = product.address, phoneNumber =product.phoneNumber, inn = product.inn, organisationName = product.organisationName, usersRoles = product.usersRoles)

       return usersProductRepository.save(new)
    }
    fun edit(id: Long,product: UsersProduct):UsersProduct=usersProductRepository.save(product.copy(id=id))

    fun remove(id:UsersProduct)
    {
        usersProductRepository.delete(id)
    }

}