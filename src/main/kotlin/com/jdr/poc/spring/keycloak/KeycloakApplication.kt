package com.jdr.poc.spring.keycloak

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KeycloakApplication

fun main(args: Array<String>) {
	runApplication<KeycloakApplication>(*args)
}
