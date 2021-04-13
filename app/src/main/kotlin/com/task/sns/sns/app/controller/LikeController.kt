package com.task.sns.sns.app.controller

import com.task.sns.sns.app.request.LikeRequest
import com.task.sns.sns.app.service.UserDetailsImpl
import com.task.sns.sns.domain.entity.Like
import com.task.sns.sns.domain.repository.LikeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.sql.SQLException
import java.sql.SQLIntegrityConstraintViolationException
import javax.transaction.Transactional

@RestController
@RequestMapping("/api/v1")
class LikeController {

    @Autowired
    lateinit var likeRepository: LikeRepository

    @PostMapping("/post/like")
    fun likePost(@AuthenticationPrincipal userDetailsImpl: UserDetailsImpl, @ModelAttribute likeRequest:LikeRequest, model: Model): Like? {
        if(!likeRepository.existsByUserIdAndPostId(userDetailsImpl.user.userId, likeRequest.postId)) {
            return likeRepository.save(
                Like(
                    likeRequest.likeId,
                    userDetailsImpl.user.userId,
                    likeRequest.postId
                )
            )
        } else {
            throw ResponseStatusException(HttpStatus.CONFLICT)
        }
    }

    @DeleteMapping("/post/unlike/{post_id}")
    @Transactional
    fun unlikePost(@AuthenticationPrincipal userDetailsImpl: UserDetailsImpl, @PathVariable(value = "post_id") postId: Int) {
        likeRepository.deleteByUserIdAndPostId(userDetailsImpl.user.userId, postId)
    }

    @GetMapping("/post/liked/{post_id}")
    fun hasLiked(@AuthenticationPrincipal userDetailsImpl: UserDetailsImpl, @PathVariable(value = "post_id") postId: Int): Like? {
        return likeRepository.findByUserIdAndPostId(userDetailsImpl.user.userId, postId)
    }

}
