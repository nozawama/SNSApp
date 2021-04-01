package com.task.sns.sns.app.service

import com.task.sns.sns.app.request.UserRequest

interface IUserDetailsService {
    fun registerUser(userRequest: UserRequest, rawPassword: String)
}