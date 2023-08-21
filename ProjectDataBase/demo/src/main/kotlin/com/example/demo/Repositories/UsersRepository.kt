package com.example.demo.Repositories

import com.example.demo.Models.Users
import org.springframework.data.jpa.repository.JpaRepository

interface  UsersRepository :JpaRepository<Users,Long>
