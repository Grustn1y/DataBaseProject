package com.example.demo.Controllers

import com.example.demo.Service.*
import com.example.demo.Models.UsersProduct
import lombok.RequiredArgsConstructor
import  org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequiredArgsConstructor
@RestController
@RequestMapping("Users")
class UsersProductController(private val productsService: UsersProductsService)
{
 @GetMapping("GetAll")
 fun getAll():List<UsersProduct>
 {
     return productsService.all()
 }
    @PostMapping
    fun create(@RequestBody product:UsersProduct)
    {
      productsService.add(product)
    }
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)

    fun  read(@PathVariable id: Long,@RequestBody product:UsersProduct)
    {
        productsService.edit(id,product)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id:UsersProduct)
    {
        productsService.remove(id)
    }
}