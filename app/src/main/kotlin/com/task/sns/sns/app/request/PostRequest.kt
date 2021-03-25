package com.task.sns.sns.app.request

import java.util.*

data class PostRequest (
    var postId : Int = 0,
    var userId : Int = 0,
    var comment : String = "",
    var createAt : Date = Date()
)