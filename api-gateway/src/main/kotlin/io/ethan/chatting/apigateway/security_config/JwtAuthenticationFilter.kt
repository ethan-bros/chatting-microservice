package io.ethan.chatting.apigateway.security_config

import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.security.core.context.ReactiveSecurityContextHolder
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

class JwtAuthenticationFilter(private val tokenProvider: JwtTokenProvider) : WebFilter{

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        val token = extractToken(exchange.request)

        if (!token.isNullOrBlank()) {
            try {
                val claims = tokenProvider.validateToken(token)
                val authentication = tokenProvider.getAuthentication(claims)

                // 인증 정보를 컨텍스트에 저장
                return chain.filter(exchange)
                    .contextWrite(ReactiveSecurityContextHolder.withAuthentication(authentication))

                // 내부 서비스로 전달할 헤더 추가
                val mutatedRequest = exchange.request.mutate()
                    .header("X-User-Id", claims.subject)
                    .header("X-User-Roles", (claims["roles"] as List<*>).joinToString(","))
                    .build()

                return chain.filter(exchange.mutate().request(mutatedRequest).build())
            } catch (e: Exception) {
                 log.error("JWT token validation failed: ${e.message}")
            }
        }

        return chain.filter(exchange)
    }

    private fun extractToken(request: ServerHttpRequest): String? {
        val bearerToken = request.headers.getFirst(HttpHeaders.AUTHORIZATION)
        return if (!bearerToken.isNullOrBlank() && bearerToken.startsWith("Bearer ")) {
            bearerToken.substring(7)
        } else null
    }
}