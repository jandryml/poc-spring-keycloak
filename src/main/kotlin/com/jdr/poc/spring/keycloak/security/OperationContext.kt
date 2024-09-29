package com.jdr.poc.spring.keycloak.security

data class OperationContext(
    val authId: String,
    val username: String,
    val email: String
)