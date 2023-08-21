package com.example.demo.Controllers

import com.example.demo.Service.*
import com.example.demo.Models.Users
import lombok.RequiredArgsConstructor
import  org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequiredArgsConstructor
@RestController
@RequestMapping("Users")
class UsersController(private val productsService: UsersService)
{
 @GetMapping("GetAll")
 fun getAll():List<Users>
 {
     return productsService.all()
 }
    @PostMapping
    fun create(@RequestBody product:Users)
    {
      productsService.add(product)
    }
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)

    fun  read(@PathVariable id: Long,@RequestBody product:Users)
    {
        productsService.edit(id,product)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id:Users)
    {
        productsService.remove(id)
    }
}