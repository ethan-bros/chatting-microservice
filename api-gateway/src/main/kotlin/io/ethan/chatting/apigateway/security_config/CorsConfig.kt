package io.ethan.chatting.apigateway.security_config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CorsConfig {

    @Bean
    fun corsWebFilter(): CorsWebFilter {
        val corsConfig = CorsConfiguration()
        corsConfig.allowedOrigins = listOf("*")
        corsConfig.allowedMethods = listOf("*")
        corsConfig.allowedHeaders = listOf("*")
        corsConfig.maxAge = 3600L

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", corsConfig)

        return CorsWebFilter(source)
    }
}