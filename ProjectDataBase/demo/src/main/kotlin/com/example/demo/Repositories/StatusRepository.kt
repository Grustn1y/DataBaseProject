package com.example.demo.Repositories

import com.example.demo.Models.Status
import org.springframework.data.jpa.repository.JpaRepository

interface StatusRepository:JpaRepository<Status,Long>
