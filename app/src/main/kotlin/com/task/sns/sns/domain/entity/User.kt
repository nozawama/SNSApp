package com.task.sns.sns.domain.entity

import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @field:NotNull
    @Column(name = "user_id", columnDefinition="INT UNSIGNED")
    var userId: Int = 0,

    @field:NotBlank
    @Column(columnDefinition="VARCHAR(50)", nullable = false)
    var name: String = "",

    @field:NotBlank
    @field:Size(min = 1, max = 16)
    @Column(name = "login_id", columnDefinition="VARCHAR(16)", unique = true, nullable = false)
    var loginId: String = "",

    @field:NotBlank
    @Column(columnDefinition="VARCHAR(64)", nullable = false)
    var password: String = "",

)