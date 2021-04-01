package com.task.sns.sns.app.service

import com.task.sns.sns.domain.entity.User
import com.task.sns.sns.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl: UserDetailsService {
    @Autowired
    lateinit var userRepository: UserRepository

    override fun loadUserByUsername(loginId: String?): UserDetails {
        var user: User? = null

        if (loginId != null) {
            user = userRepository.findByLoginId(loginId)
        }

        if (user == null) {
            throw UsernameNotFoundException(loginId)
        }

        return UserDetailsImpl(user)
    }
}