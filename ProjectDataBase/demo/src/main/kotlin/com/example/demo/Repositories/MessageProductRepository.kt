package com.example.demo.Repositories

import com.example.demo.Models.MessageProduct
import org.springframework.data.jpa.repository.JpaRepository

interface MessageProductRepository:JpaRepository<MessageProduct,Long>