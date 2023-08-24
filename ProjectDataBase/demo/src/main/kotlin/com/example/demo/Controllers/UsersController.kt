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
    @GetMapping("get_all")
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
    @ResponseStatus(HttpStatus.OK)
    fun  get(@PathVariable id: Long):Users
    {
      return productsService.get(id)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id:Users)
    {
        productsService.remove(id)
    }
}