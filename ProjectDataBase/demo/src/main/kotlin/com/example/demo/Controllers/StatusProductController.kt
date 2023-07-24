package com.example.demo.Controllers

import com.example.demo.Service.*
import com.example.demo.Models.StatusProduct
import com.example.demo.Models.UsersProduct
import lombok.RequiredArgsConstructor
import  org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequiredArgsConstructor
@RestController
@RequestMapping("Status")
class StatusProductController(private val productService: StatusProductService)
{
@GetMapping("GetAll")
fun getAll():List<StatusProduct>
{
    return productService.all()
}

    @PostMapping
    fun create(@RequestBody product: StatusProduct)
    {
        productService.add(product)
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    fun read(@PathVariable id:Long,@RequestBody product:StatusProduct)
    {
        productService.
    }
}