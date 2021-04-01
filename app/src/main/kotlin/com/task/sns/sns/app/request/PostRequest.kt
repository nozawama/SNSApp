package com.task.sns.sns.app.request

import com.task.sns.sns.domain.entity.User
import java.util.*

data class PostRequest (
    var postId: Int = 0,
    var user: User = User(),
    //var userId: Int = 0,
    var comment: String = "",
    var createAt: Date = Date()
)