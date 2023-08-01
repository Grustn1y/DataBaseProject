package com.example.demo.Controllers

import com.example.demo.Models.MessageProduct
import com.example.demo.Service.MessageProductService
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequiredArgsConstructor
@RestController
@RequestMapping("Message")
class MessageProductController(private val productService: MessageProductService)
{
    @GetMapping("GetAll")
    fun getAll():List<MessageProduct>
    {
       return productService.all()
    }
    @PostMapping
    fun create(@RequestBody product: MessageProduct)
    {
        productService.add(product)
    }
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)

    fun  read(@PathVariable id: Long, @RequestBody product: MessageProduct)
    {
        productService.edit(id,product)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id:MessageProduct)
    {
        productService.remove(id)
    }
}