package com.task.sns.sns.app.config

import com.task.sns.sns.app.service.UserDetailsServiceImpl
import com.task.sns.sns.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
class SecurityConfig @Autowired constructor(private val userRepository: UserRepository): WebSecurityConfigurerAdapter() {
    @Autowired
    lateinit var userDetailsService: UserDetailsServiceImpl

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    override fun configure(web: WebSecurity) {
        // セキュリティ設定を無視
        web.ignoring().antMatchers(
            "/css/**",
            "/js/**",
            "/api/**"
        )
    }

    override fun configure(http: HttpSecurity) {
        // 認可の設定
        http.authorizeRequests().antMatchers("/", "/index", "/registration", "/api/**").permitAll() // login, registrationはアクセス許可
            .anyRequest().authenticated() // その他は認証無しの場合アクセス不可

        http.formLogin() // フォームログインの有効化
            .loginProcessingUrl("/login")
            .loginPage("/index")
            .failureHandler(AuthenticationFailureHandler())
            .defaultSuccessUrl("/post")
            .usernameParameter("loginId").passwordParameter("password")

        http.logout()
            .logoutRequestMatcher(AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/index")

    }

    override fun configure(auth: AuthenticationManagerBuilder) {
//        auth.inMemoryAuthentication()
//            .withUser("admin")
//            .password(passwordEncoder().encode("root"))
//            .authorities("ROLE_USER")

        auth.userDetailsService(userDetailsService) //ユーザ検索用クラスの設定
    }

}
