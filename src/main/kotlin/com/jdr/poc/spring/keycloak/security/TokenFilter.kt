package com.jdr.poc.spring.keycloak.security

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@Component
class TokenFilter : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authentication = SecurityContextHolder.getContext().authentication

        if (authentication is JwtAuthenticationToken) {
            val jwt = authentication.token

            // Extract desired parameters from the JWT claims
            val username = jwt.claims["preferred_username"] as? String
            val email = jwt.claims["email"] as? String

            // Add parameters to request context
            request.setAttribute("username", username)
            request.setAttribute("email", email)
        }

        filterChain.doFilter(request, response)
    }
}