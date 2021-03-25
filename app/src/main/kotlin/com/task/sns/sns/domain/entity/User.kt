package com.task.sns.sns.domain.entity

import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
data class User (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @field:NotNull
    @Column(name = "user_id", columnDefinition="INT UNSIGNED")
    var userId : Int = 0,

    @field:NotNull
    @Column(nullable = false, columnDefinition="VARCHAR(50)")
    var name : String = "",

    @field:NotNull
    @Column(name = "login_id", columnDefinition="VARCHAR(16)", unique = true, nullable = false)
    var loginId : String = "",

    @field:NotNull
    @Column(nullable = false, columnDefinition="VARCHAR(64)")
    var password : String = ""

)