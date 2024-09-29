package com.jdr.poc.spring.keycloak.security

import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.stereotype.Component
import org.springframework.web.context.WebApplicationContext

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
class OperationContext {
    private var user: User? = null
    

    fun setUser(user: User) {
        this.user = user
    }

    fun getUser(): User {
        return user ?: throw IllegalStateException("User is not set")
    }
}