package com.task.sns.sns.app.service

import com.task.sns.sns.app.request.UserRequest
import com.task.sns.sns.domain.entity.User
import com.task.sns.sns.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserManagerServiceImpl: IUserDetailsService {
    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var passwordEncoder: PasswordEncoder

    // ユーザーを登録するメソッド
    override fun registerUser(userRequest: UserRequest, rawPassword: String) {
        // エンコードしたパスワードでユーザーを作成する
        userRequest.password = passwordEncoder.encode(rawPassword)

        userRepository.save(
            User(
                userRequest.userId,
                userRequest.name,
                userRequest.loginId,
                userRequest.password
            )
        )
    }
}