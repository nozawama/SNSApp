package com.task.sns.sns.app.request

data class UserRequest (
    var userId : Int = 0,
    var name : String = "",
    var loginId : String = "",
    var password : String = ""
)