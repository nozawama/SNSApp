package com.task.sns.sns.app.controller

import com.task.sns.sns.app.request.PostRequest
import com.task.sns.sns.app.service.UserDetailsImpl
import com.task.sns.sns.domain.entity.Post
import com.task.sns.sns.domain.repository.LikeRepository
import com.task.sns.sns.domain.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class PostController {
    @Autowired
    lateinit var postRepository: PostRepository

    @Autowired
    lateinit var likeRepository: LikeRepository

    @PostMapping("/post")
    fun createPost(@ModelAttribute postRequest: PostRequest, model: Model): String {
        postRepository.save(
            Post(
                postRequest.postId,
                postRequest.user,
                postRequest.comment,
                postRequest.createAt
            )
        )

        return "redirect:/post"
    }

    @GetMapping("/post")
    fun getPostList(@AuthenticationPrincipal userDetailsImpl: UserDetailsImpl, model: Model) : String {
        model.addAttribute("posts", postRepository.findAll().sortedByDescending { it.createAt })

        model.addAttribute("user", userDetailsImpl.user)

        model.addAttribute("likes", likeRepository.findPostIdByUserId(userDetailsImpl.user.userId))

        model.addAttribute("count", likeRepository.findAll().groupingBy { it.postId }.eachCount())

        return "posts"
    }

    @PostMapping("/post/delete")
    fun deletePost(@AuthenticationPrincipal userDetailsImpl: UserDetailsImpl, @ModelAttribute postRequest: PostRequest): String {
        val post = postRepository.findById(postRequest.postId)
        if(post.isPresent && post.get().user.userId == userDetailsImpl.user.userId) {
            postRepository.deleteById(postRequest.postId)
        }

        return "redirect:/post"
    }
}
