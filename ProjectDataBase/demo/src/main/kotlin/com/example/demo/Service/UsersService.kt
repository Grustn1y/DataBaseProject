package com.example.demo.Service

import com.example.demo.Repositories.UsersRepository
import com.example.demo.Models.*
import org.springframework.stereotype.Service

@Service

class UsersService (private val usersRepository: UsersRepository)
{
    fun all():List<Users> = usersRepository.findAll()

    fun get(id:Long):Users
    {
        val info=usersRepository.findById(id)

        if (info.isPresent)
        {
            return info.get()
        }
        
        else
        {
            throw RuntimeException("Not exists")
        } 
    }

    fun add(product: Users):Users
    {
       val new:Users= Users(
               firstName = product.firstName,
               lastName = product.lastName,
               email = product.email,
               password = product.password,
               thirdName = product.thirdName,
               address = product.address,
               phoneNumber = product.phoneNumber,
               inn = product.inn,
               organisationName = product.organisationName,
               usersRoles = product.usersRoles
       )

       return usersRepository.save(new)
    }
    
    fun remove(id:Users)
    {
        usersRepository.delete(id)
    }

}