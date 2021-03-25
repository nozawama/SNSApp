package com.task.sns.sns.app.controller

import com.task.sns.sns.app.request.PostRequest
import com.task.sns.sns.domain.entity.Post
import com.task.sns.sns.domain.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*;

@Controller
class PostController {

    @Autowired
    lateinit var postRepository: PostRepository

    @PostMapping("/post")
    fun createPost(@ModelAttribute postRequest: PostRequest, model: Model): String {
        postRepository.save(
            Post(
                postRequest.postId,
                postRequest.userId,
                postRequest.comment,
                postRequest.createAt
            )
        )

        model.addAttribute("posts", postRepository.findAll())

        return "index"
    }

    @GetMapping("/")
    fun getPostList(model: Model) : String {

        model.addAttribute("posts", postRepository.findAll())

        return "index"
    }

}