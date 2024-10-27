package io.ethan.chatting.apigateway.security_config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "security")
data class SecurityProperties(
    val jwt: JwtProperties = JwtProperties()
) {
    data class JwtProperties(
        val secret: String = "",
        val expiration: Long = 0,
        val allowedPaths: List<String> = mutableListOf()
    )
}
