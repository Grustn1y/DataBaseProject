package com.example.demo.Models

import javax.persistence.*
import com.fasterxml.jackson.annotation.*
import org.jetbrains.annotations.NotNull
import org.springframework.data.annotation.Id
import java.sql.Timestamp

@Entity
@Table(name="Status")
data class Status(

    @Id
    @javax.persistence.Id
    @NotNull
    @JsonProperty("Id")
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    val id:Long=0L,

    @JsonProperty("StatusAppeal")
    @Column(name = "statusAppeal")
    @NotNull
    val statusAppeal: StatusAppeal,

    @JsonProperty("AppealId")
    @NotNull
    @Column(name = "appealId")
    val appealId:Long=0L,

    @JsonProperty("DateOfCreate")
    @NotNull
    @Column(name = "dateOfCreate")
    val dateOfCreate:Timestamp,

)
