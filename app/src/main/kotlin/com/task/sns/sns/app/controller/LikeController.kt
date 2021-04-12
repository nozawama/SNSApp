package com.task.sns.sns.app.controller

import com.task.sns.sns.app.request.LikeRequest
import com.task.sns.sns.domain.entity.Like
import com.task.sns.sns.domain.repository.LikeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import javax.transaction.Transactional

@RestController
@RequestMapping("/api/v1")
class LikeController {

    @Autowired
    lateinit var likeRepository: LikeRepository

    @PostMapping("/post/like")
    fun likePost(@ModelAttribute likeRequest:LikeRequest, model: Model): Like {
        return likeRepository.save(
            Like(
                likeRequest.likeId,
                likeRequest.userId,
                likeRequest.postId
            )
        )
    }

    @DeleteMapping("/post/unlike/{user_id}/{post_id}")
    @Transactional
    fun unlikePost(@PathVariable(value = "user_id") userId: Int, @PathVariable(value = "post_id") postId: Int) {
        likeRepository.deleteByUserIdAndPostId(userId, postId)
    }

    @GetMapping("/post/liked/{user_id}/{post_id}")
    fun hasLiked(@PathVariable(value = "user_id") userId: Int, @PathVariable(value = "post_id") postId: Int): Like? {
        return likeRepository.findByUserIdAndPostId(userId, postId)
    }

}
