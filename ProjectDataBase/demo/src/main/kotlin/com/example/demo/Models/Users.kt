package com.example.demo.Models

import javax.persistence.*
import com.fasterxml.jackson.annotation.*
import org.jetbrains.annotations.NotNull
import org.springframework.data.annotation.Id


@Entity
@Table(name = "Users")
data class Users(

    @javax.persistence.Id @Id
    @NotNull
    @JsonProperty("id")
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long=0L,

    @JsonProperty("Email")
    @NotNull
    @Column(unique = true,name = "email", length = 20)
    val email:String="",

    @JsonProperty("Password")
    @NotNull
    @Column(name = "password", length = 20)
    val password:String="",

    @JsonProperty("UserRole")
    @NotNull
    @Column(name = "userRole")
    val usersRoles: UsersRoles,

    @JsonProperty("FirstName")
    @NotNull
    @Column(name = "firstName", length =20)
    val firstName:String="",

    @JsonProperty("LastName")
    @NotNull
    @Column(name = "lastName", length = 20)
    val lastName:String="",

    @JsonProperty("ThirdName")
    @Column(name = "thirdName", length = 20)
    val thirdName:String="",

    @JsonProperty("Address")
    @Column(name = "address", length = 25)
    val address:String="",

    @JsonProperty("PhoneNumber")
    @Column(name = "phoneNumber", length = 15)
    val phoneNumber:String="",

    @JsonProperty("Inn")
    @NotNull
    @Column(name = "inn", length = 10)
    val inn:String="",

    @JsonProperty("Organisation_Name")
    @NotNull
    @Column(name = "organisationName", length = 30)
    val organisationName:String=""
)

