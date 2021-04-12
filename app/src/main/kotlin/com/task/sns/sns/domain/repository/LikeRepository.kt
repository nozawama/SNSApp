package com.task.sns.sns.domain.repository

import com.task.sns.sns.domain.entity.Like
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface LikeRepository : JpaRepository<Like, Int> {
    @Query("SELECT l.postId FROM Like l WHERE l.userId = ?1")
    fun findPostIdByUserId(userId: Int): List<Int>?
    fun findByUserIdAndPostId(userId: Int, postId: Int): Like?
    fun deleteByUserIdAndPostId(userId: Int, postId: Int)
}
