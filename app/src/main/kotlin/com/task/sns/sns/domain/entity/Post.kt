package com.task.sns.sns.domain.entity

import org.jetbrains.annotations.NotNull
import java.util.*
import javax.persistence.*

@Entity
data class Post (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @field:NotNull
    @Column(name = "post_id", columnDefinition = "INT UNSIGNED")
    var postId : Int = 0,

    @field:NotNull
    @Column(name = "user_id", columnDefinition = "INT UNSIGNED")
    var userId : Int = 0,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(140)")
    var comment : String = "",

    @field:NotNull
    @Column(name = "create_at")
    var createAt : Date = Date()

)
