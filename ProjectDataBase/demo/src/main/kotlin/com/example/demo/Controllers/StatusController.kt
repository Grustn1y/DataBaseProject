package com.example.demo.Controllers

import com.example.demo.Service.*
import com.example.demo.Models.Status
import lombok.RequiredArgsConstructor
import  org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequiredArgsConstructor
@RestController
@RequestMapping("Status")
class StatusController(private val productService: StatusService)
{
    @GetMapping("GetAll")
    fun getAll():List<Status>
    {
    return productService.all()
    }

    @PostMapping
    fun create(@RequestBody product: Status)
    {
        productService.add(product)
    }

  @GetMapping("{id}")
  @ResponseStatus(HttpStatus.FOUND)
  fun read(@PathVariable id:Long,@RequestBody product: Status)
  {
   productService.edit(id,product)
  }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id:Status)
    {
        productService.remove(id)
    }
}