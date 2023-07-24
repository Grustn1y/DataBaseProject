package com.example.demo.Models

import javax.persistence.*
import com.fasterxml.jackson.annotation.*
import org.jetbrains.annotations.NotNull
import org.springframework.data.annotation.Id
import java.sql.Timestamp

@Entity
@Table(name="Status")
data class StatusProduct(
        @Id
        @javax.persistence.Id
     @NotNull
     @JsonProperty("Id")
     @Column(name = "id")
     @GeneratedValue(strategy=GenerationType.AUTO)
     val id:Long=0L,
        @JsonProperty("Status_Appeal")
        @Column(name = "statusAppeal")
        @NotNull
        val statusAppeal: StatusAppeal,

        @JsonProperty("Appeal_Id")
        @NotNull
        @Column(name = "appealId")
        val appealId:Long=0L,

        @JsonProperty("Date_of_Create")
        @NotNull
        @Column(name = "dateCreate")
        val dateCreate:Timestamp,
        )
