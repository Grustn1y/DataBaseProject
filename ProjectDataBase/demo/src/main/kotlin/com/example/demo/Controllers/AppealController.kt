package com.example.demo.Controllers

import com.example.demo.Service.*
import com.example.demo.Models.Appeal
import lombok.RequiredArgsConstructor
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequiredArgsConstructor
@RestController
@RequestMapping("Appeal")
 class AppealController(private val productService:AppealService)
{
    @GetMapping("GetAll")
    fun all():List<Appeal>
    {
        return productService.all()
    }
    @PostMapping
    fun craate(@RequestBody product: Appeal)
    {
        productService.add(product)
    }
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)

    fun  read(@PathVariable id: Long, @RequestBody product:Appeal)
    {
        productService.edit(id,product)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id:Appeal)
    {
        productService.remove(id)
    }

    @GetMapping("{start}/{end}")
    fun readAll(@PathVariable start:Int,@PathVariable end:Int)
    {
        productService.readAll(start, end)
    }
 }