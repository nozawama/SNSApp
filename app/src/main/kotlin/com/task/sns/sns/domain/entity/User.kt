package com.task.sns.sns.domain.entity

import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
data class User (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @field:NotNull
    @Column(name = "user_id", columnDefinition="INT UNSIGNED")
    var userId: Int = 0,

    @field:NotBlank
    @Column(columnDefinition="VARCHAR(50)", nullable = false)
    var name: String = "",

    @field:NotBlank
    @Column(name = "login_id", columnDefinition="VARCHAR(16)", unique = true, nullable = false)
    var loginId: String = "",

    @field:NotBlank
    @Column(columnDefinition="VARCHAR(64)", nullable = false)
    var password: String = "",

//    @OneToMany(mappedBy = "user")
//    @Column(name = "posts")
//    var posts: MutableList<Post>?

)