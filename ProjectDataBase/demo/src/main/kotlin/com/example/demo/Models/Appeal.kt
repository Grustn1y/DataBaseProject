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
@OneToOne
@JoinColumn(name="userId", referencedColumnName = "id")
val userId:Users,


        @JsonProperty("EmployeeId")
@OneToOne()
        @JoinColumn(name="employeeId", referencedColumnName = "id", nullable = true)
        val employeeId:Users,

        @JsonProperty("StatusId")
@OneToOne()
@JoinColumn(name="statusId", referencedColumnName = "id")
val statusId:Status,

        @JsonProperty("DateOfCreate")
@NotNull
@Column(name = "dateOfCreate")
val dateOfCreate:Timestamp
)
