package com.example.demo.Models

import com.fasterxml.jackson.annotation.JsonProperty
import org.jetbrains.annotations.NotNull
import org.springframework.data.annotation.Id
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "Appeal")
data class Appeal(

        @javax.persistence.Id @Id
        @NotNull
        @JsonProperty("id")
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id:Long=0L,

        @JsonProperty("UserId")
        @Column(name="userId")
        val userId:Long,


        @JsonProperty("EmployeeId")
        @Column(name="employeeId", nullable = true)
        val employeeId:Long,

        @JsonProperty("StatusId")
        @Column(name="statusId")
        val statusId:Long,

        @JsonProperty("DateOfCreate")
        @NotNull
        @Column(name = "dateOfCreate")
        val dateOfCreate:Timestamp
)
