package com.example.demo.Repositories

import com.example.demo.Models.UsersProduct
import org.springframework.data.jpa.repository.JpaRepository

interface  UsersProductRepository :JpaRepository<UsersProduct,Long>
