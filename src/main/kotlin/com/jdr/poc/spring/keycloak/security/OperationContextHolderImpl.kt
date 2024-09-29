package com.jdr.poc.spring.keycloak.security

import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.stereotype.Component
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.context.annotation.RequestScope

@Component
@RequestScope
class OperationContextHolderImpl : OperationContextHolder {
    private var operationContext: OperationContext? = null

    override fun setOperationContext(operationContext: OperationContext) {
        this.operationContext = operationContext
    }

    override fun getOperationContext(): OperationContext {
        return operationContext ?: throw IllegalStateException("OperationContext is not set")
    }
}