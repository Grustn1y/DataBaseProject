package com.example.demo.Controllers

import com.example.demo.Models.Message
import com.example.demo.Service.MessageService
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequiredArgsConstructor
@RestController
@RequestMapping("Message")
class MessageController(private val productService: MessageService)
{
    @GetMapping("GetAll")
    fun getAll():List<Message>
    {
       return productService.all()
    }
    @PostMapping
    fun create(@RequestBody product: Message)
    {
        productService.add(product)
    }
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)

    fun  read(@PathVariable id: Long, @RequestBody product: Message)
    {
        productService.edit(id,product)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id:Message)
    {
        productService.remove(id)
    }
}