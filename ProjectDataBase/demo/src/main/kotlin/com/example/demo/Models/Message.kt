package com.example.demo.Models

import javax.persistence.*
import com.fasterxml.jackson.annotation.*
import org.jetbrains.annotations.NotNull
import org.springframework.data.annotation.Id

@Entity
@Table(name = "Message")

data class Message(

    @javax.persistence.Id @Id
    @JsonProperty("id")
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long=0L,

    @JsonProperty("appealId")
    @Column(name = "appealId")
    val appealId:Long,

    @JsonProperty("ownerId")
    @Column(name = "ownerId")
    val ownerId:Long,

    @JsonProperty("appealHeader")
    @NotNull
    @Column(name = "appealHeader", length = 155)
    val appealHeader:String="",

    @JsonProperty("Content")
    @NotNull
    @Column(name = "content")
    val content:String="",

    @JsonProperty("dateOfCreate")
    @NotNull
    @Column(name="dateOfCreate")
    val dateOfCreate:java.sql.Timestamp
)