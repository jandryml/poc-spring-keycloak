package com.jdr.poc.spring.keycloak.security

interface OperationContextHolder {
    fun setOperationContext(operationContext: OperationContext)
    fun getOperationContext(): OperationContext
}