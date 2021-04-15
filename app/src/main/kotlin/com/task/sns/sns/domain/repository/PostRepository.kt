package com.task.sns.sns.domain.repository

import com.task.sns.sns.domain.entity.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Int>
