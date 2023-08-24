package com.example.demo.Controllers

import com.example.demo.Service.*
import com.example.demo.Models.Appeal
import lombok.RequiredArgsConstructor
import org.springframework.data.domain.Page

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequiredArgsConstructor
@RestController
@RequestMapping("Appeal")
 class AppealController(private val productService:AppealService)
{
    @GetMapping("get_all")
    fun all():List<Appeal>
    {
        return productService.all()
    }

    @PostMapping
    fun create(@RequestBody product: Appeal)
    {
        productService.add(product)
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun  get(@PathVariable id: Long):Appeal
    {
        return productService.get(id)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id:Appeal)
    {
        productService.remove(id)
    }

    @GetMapping("{start}/{end}")
    fun readFromTo(@PathVariable start:Int,@PathVariable end:Int):Page<Appeal>
    {
         return productService.readAppealFromTo(start, end)
    }
 }