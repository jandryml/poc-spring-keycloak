package com.jdr.poc.spring.keycloak.security

data class User(
    val authId: String,
    val username: String,
    val email: String
)