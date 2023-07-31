package com.example.demo.Controllers

import com.example.demo.Service.*
import com.example.demo.Models.AppealProduct
import com.example.demo.Models.UsersProduct
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequiredArgsConstructor
@RestController
@RequestMapping("Appeal")
 class AppealProductController(private val productService:AppealProductService)
{
    @GetMapping("GetAll")
    fun getAll():List<AppealProduct>
    {
        return productService.all()
    }
    @PostMapping
    fun create(@RequestBody product: AppealProduct)
    {
        productService.add(product)
    }
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)

    fun  read(@PathVariable id: Long, @RequestBody product:AppealProduct)
    {
        productService.edit(id,product)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id:AppealProduct)
    {
        productService.remove(id)
    }
 }