package com.task.sns.sns.domain.entity

import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
data class Post(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @field:NotNull
    @Column(name = "post_id", columnDefinition = "INT UNSIGNED")
    var postId: Int = 0,

    @ManyToOne
    var user: User,

//    @field:NotNull
//    @Column(name = "user_id", columnDefinition = "INT UNSIGNED")
//    var userId: Int = 0,

    @field:NotBlank
    @Column(columnDefinition = "VARCHAR(140)", nullable = false)
    var comment: String = "",

    @field:NotNull
    @Column(name = "create_at", nullable = false)
    var createAt: Date = Date()

)
