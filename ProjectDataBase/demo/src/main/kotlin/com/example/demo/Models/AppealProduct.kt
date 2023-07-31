package com.example.demo.Models

import com.fasterxml.jackson.annotation.JsonProperty
import org.jetbrains.annotations.NotNull
import org.springframework.data.annotation.Id
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "Appeal")
data class AppealProduct(
        @javax.persistence.Id @Id
@NotNull
@JsonProperty("id")
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.AUTO)
val id:Long=0L,

@JsonProperty("User_Id")
@OneToOne
@JoinColumn(name="userId", referencedColumnName = "id")
val userId:UsersProduct,


@JsonProperty("Employee_Id")
@OneToOne()
@JoinColumn(name="employeeId", referencedColumnName = "id")
val employeeId:UsersProduct,

@JsonProperty("Status_Id")
@OneToOne()
@JoinColumn(name="statusId", referencedColumnName = "id")
val statusId:StatusProduct,

@JsonProperty("Date_of_create")
@NotNull
@Column(name = "dateOfCreate")
val dateOfCreate:Timestamp
)
