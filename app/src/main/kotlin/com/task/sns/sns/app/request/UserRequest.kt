package com.task.sns.sns.app.request

import com.task.sns.sns.domain.entity.Post

data class UserRequest (
    var userId: Int = 0,
    var name: String = "",
    var loginId: String = "",
    var password: String = ""
)