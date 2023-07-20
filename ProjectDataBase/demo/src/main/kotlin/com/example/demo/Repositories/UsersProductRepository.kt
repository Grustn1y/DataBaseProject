package com.example.demo.Repositories

import com.example.demo.Models.UsersProduct
import com.example.demo.Repositories.UsersProductRepository
import org.springframework.data.jpa.repository.JpaRepository

interface  UsersProductRepository :JpaRepository<UsersProduct,Long>
