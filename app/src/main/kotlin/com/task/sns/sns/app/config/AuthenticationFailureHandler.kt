package com.task.sns.sns.app.config

import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import kotlin.jvm.Throws

class AuthenticationFailureHandler: AuthenticationFailureHandler {

    @Throws(IOException::class, ServletException::class)
    override fun onAuthenticationFailure(
        httpServletRequest: HttpServletRequest,
        httpServletResponse: HttpServletResponse,
        authenticationException: AuthenticationException
    ) {
        var errorId = ""

        if (authenticationException is BadCredentialsException) {
            errorId = "ERR-0001"
        }

        httpServletResponse.sendRedirect(httpServletRequest.contextPath + "/index?error=" + errorId)
    }

}