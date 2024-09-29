package com.jdr.poc.spring.keycloak.security

data class User(
    val authId: String, // keycloak id
    val username: String,
    val email: String
)