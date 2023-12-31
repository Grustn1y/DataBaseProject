package com.example.demo.Models

import javax.persistence.*
import com.fasterxml.jackson.annotation.*
import org.jetbrains.annotations.NotNull
import org.springframework.data.annotation.Id

@Entity
@Table(name = "Message")

data class MessageProduct(
@javax.persistence.Id @Id
@JsonProperty("id")
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.AUTO)
val id:Long=0L,

@JsonProperty("appealId")
@OneToOne
@JoinColumn(name = "appealId", referencedColumnName = "id")
val appealId:AppealProduct,

@JsonProperty("ownerId")
@OneToOne
@JoinColumn(name = "ownerId", referencedColumnName = "id")
val ownerId:UsersProduct,

@JsonProperty("Content")
@NotNull
@Column(name = "content", length = 255)
val content:String="",

@JsonProperty("dateOfCreate")
@NotNull
@Column(name="dateOfCreate")
val dateOfCreate:java.sql.Timestamp
)