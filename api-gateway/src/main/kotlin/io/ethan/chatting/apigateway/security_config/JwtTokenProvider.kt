package io.ethan.chatting.apigateway.security_config

import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.stereotype.Component

@Component
class JwtTokenProvider {
    @Value("\${jwt.secret}")
    private lateinit var jwtSecret: String

    @Value("\${jwt.expiration}")
    private var jwtExpiration: Long = 0

    fun validateToken(token: String): Claims {
        return try {
            Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .body
        } catch (e: JwtException) {
            throw InvalidTokenException("Invalid JWT token")
        }
    }

    fun getAuthentication(claims: Claims): Authentication {
        val roles = claims["roles"] as List<String>
        val authorities = roles.map { SimpleGrantedAuthority(it) }

        return UsernamePasswordAuthenticationToken(
            claims.subject,
            null,
            authorities
        )
    }
}