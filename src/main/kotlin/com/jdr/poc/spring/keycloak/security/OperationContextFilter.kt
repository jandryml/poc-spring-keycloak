package com.jdr.poc.spring.keycloak.security

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import org.springframework.core.annotation.Order
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken
import org.springframework.stereotype.Component

@Component
@Order(1)
class OperationContextFilter(
    private val operationContextHolder: OperationContextHolder
) : Filter {
    override fun doFilter(servletRequest: ServletRequest, servletResponse: ServletResponse, filterChain: FilterChain) {
        println("in filter")
        val authentication = SecurityContextHolder.getContext().authentication
        if (authentication is JwtAuthenticationToken) {
            val operationContext = createOperationContext(authentication.token)
            operationContextHolder.setOperationContext(operationContext)
        }
        filterChain.doFilter(servletRequest, servletResponse)
    }

    private fun createOperationContext(token: Jwt): OperationContext {
        val authId = token.claims["sub"] as String
        val username = token.claims["username"] as String
        val email = token.claims["email"] as String
        return OperationContext(authId, username, email)
    }
}