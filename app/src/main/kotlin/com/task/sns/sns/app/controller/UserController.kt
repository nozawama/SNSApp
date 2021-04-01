package com.task.sns.sns.app.controller

import com.task.sns.sns.app.request.UserRequest
import com.task.sns.sns.app.service.UserManagerServiceImpl
import com.task.sns.sns.domain.entity.User
import com.task.sns.sns.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
class UserController {

    @Autowired // 削除?
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var userManagerServiceImpl: UserManagerServiceImpl

    @PostMapping("/registration") // 要変更
    fun createUser(@ModelAttribute userRequest: UserRequest, model: Model): String {

        userManagerServiceImpl.registerUser(userRequest, userRequest.password)

//        userRepository.save(
//            User(
//                userRequest.userId,
//                userRequest.name,
//                userRequest.loginId
//                userRequest.password
//            )
//        )

        model.addAttribute("users", userRepository.findAll())

        return "index"
    }

    @GetMapping("/user") // 確認用
    fun getUserList(model: Model): String {

        model.addAttribute("users", userRepository.findAll())

        return "user_list"
    }

    @RequestMapping("/index")
    fun moveLoginPage(): String {
        return "index"
    }

    @RequestMapping("/registration")
    fun moveRegistrationPage(): String {
        return "registration"
    }

//    @GetMapping("/login")
//    fun moveLoginPage(): String {
//        // provision
//        return "index"
//    }

}