package com.task.sns.sns.app.controller

import com.task.sns.sns.app.request.UserRequest
import com.task.sns.sns.domain.entity.User
import com.task.sns.sns.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*;

@Controller
class UserController {

    @Autowired
    lateinit var userRepository: UserRepository

    @PostMapping("/user")
    fun createUser(@ModelAttribute userRequest: UserRequest, model: Model): String {
        userRepository.save(
            User(
                userRequest.userId,
                userRequest.name,
                userRequest.loginId,
                userRequest.password
            )
        )

        model.addAttribute("users", userRepository.findAll())

        return "user_list"
    }

    @GetMapping("/user")
    fun getUserList(model: Model): String {

        model.addAttribute("users", userRepository.findAll())

        return "user_list"
    }

    @GetMapping("/registration")
    fun moveRegistrationPage(): String {
        return "registration"
    }

    @GetMapping("/login")
    fun moveLoginPage(): String {
        // provision
        return "login"
    }

}