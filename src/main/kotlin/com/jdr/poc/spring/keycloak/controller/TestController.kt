package com.jdr.poc.spring.keycloak.controller

import com.jdr.poc.spring.keycloak.security.OperationContext
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    private val operationContext: OperationContext
) {

    @GetMapping("/test-endpoint")
    fun getData(authentication: Authentication): ResponseEntity<String> {
        val username = operationContext.getUser().username
        val email = operationContext.getUser().email

        return ResponseEntity.ok("Hello, $username! Your email is $email.")
    }
}