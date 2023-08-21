package com.example.demo.Service

import com.example.demo.Repositories.UsersRepository
import com.example.demo.Models.*
import org.springframework.stereotype.Service

@Service

class UsersService (private val usersProductRepository: UsersRepository)
{
    fun all():List<Users> = usersProductRepository.findAll()

    fun get(id:Long):Users
    {
        val info=usersProductRepository.findById(id)

        if (info.isPresent)
        {
            return info.get()
        }
        else
            throw RuntimeException("Не сущестувует")
    }

    fun add(product: Users):Users
    {
       val new:Users= Users(firstName = product.firstName, lastName = product.firstName, email = product.email, password = product.password, thirdName = product.thirdName, address = product.address, phoneNumber =product.phoneNumber, inn = product.inn, organisationName = product.organisationName, usersRoles = product.usersRoles)

       return usersProductRepository.save(new)
    }
    fun edit(id: Long,product: Users):Users=usersProductRepository.save(product.copy(id=id))

    fun remove(id:Users)
    {
        usersProductRepository.delete(id)
    }

}