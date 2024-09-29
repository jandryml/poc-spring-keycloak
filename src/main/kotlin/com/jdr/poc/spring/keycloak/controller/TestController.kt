package com.jdr.poc.spring.keycloak.controller

import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @GetMapping("/test-endpoint")
    fun getData(authentication: Authentication): ResponseEntity<String> {
//        val username = request.getAttribute("username") as? String
//        val email = request.getAttribute("email") as? String
//
//        return ResponseEntity.ok("Hello, $username! Your email is $email.")
        return ResponseEntity.ok("ss")
    }
}