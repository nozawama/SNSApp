package com.task.sns.sns.domain.repository

import com.task.sns.sns.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Int> {
    fun findByLoginId(loginId: String): User?
    fun findByName(name: String): User?
}