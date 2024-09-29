package com.jdr.poc.spring.keycloak.controller

import com.jdr.poc.spring.keycloak.security.OperationContext
import com.jdr.poc.spring.keycloak.security.OperationContextHolder
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    private val operationContextHolder: OperationContextHolder
) {

    @GetMapping("/test-endpoint")
    fun getData(authentication: Authentication): ResponseEntity<String> {
//        val username = request.getAttribute("username") as? String
//        val email = request.getAttribute("email") as? String
//
//        return ResponseEntity.ok("Hello, $username! Your email is $email.")
        return ResponseEntity.ok("ss")
    }
}