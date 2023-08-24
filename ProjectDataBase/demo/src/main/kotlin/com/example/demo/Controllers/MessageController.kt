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
    @GetMapping("get_all")
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
    @ResponseStatus(HttpStatus.OK)

    fun  get(@PathVariable id: Long):Message
    {
        return productService.get(id)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id:Message)
    {
        productService.remove(id)
    }
}