package com.task.sns.sns.domain.entity

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "Likes", uniqueConstraints = arrayOf(UniqueConstraint(columnNames = arrayOf("user_id", "post_id"))))
data class Like (

    // user_id, post_idのみで出来ない?
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @field: NotNull
    var likeId: Int = 0,

    @field: NotNull
    @Column(name = "user_id")
    var userId: Int = 0,

    @field: NotNull
    @Column(name = "post_id")
    var postId: Int = 0

)

