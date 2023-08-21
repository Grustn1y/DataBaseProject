package com.example.demo.Repositories

import com.example.demo.Models.Message
import org.springframework.data.jpa.repository.JpaRepository

interface MessageRepository:JpaRepository<Message,Long>