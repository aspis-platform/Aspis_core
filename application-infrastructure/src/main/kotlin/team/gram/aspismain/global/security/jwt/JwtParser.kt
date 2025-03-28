package team.gram.aspismain.global.security.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.InvalidClaimException
import io.jsonwebtoken.Jws
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import org.springframework.context.annotation.Lazy
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import team.gram.aspismain.global.exception.InternalServerErrorException
import team.gram.aspismain.global.security.SecurityProperties
import team.gram.aspismain.global.security.exception.ExpiredTokenException
import team.gram.aspismain.global.security.exception.InvalidTokenException
import team.gram.aspismain.global.security.exception.UnexpectedTokenException
import team.gram.team.gram.aspismain.domain.auth.model.Authority
import java.util.*

@Component
class JwtParser(
    private val securityProperties: SecurityProperties,
    @Lazy private val studentDetailsService: UserDetailsService,
    @Lazy private val managerDetailsService: UserDetailsService
) {

    fun getAuthentication(token: String): Authentication {
        try {
            val claims = getClaims(token)

            val tokenType = claims.header["typ"] as? String
            if (tokenType != JwtProperties.ACCESS) {
                throw InvalidTokenException
            }

            val userDetails = getDetails(claims.body)
            return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
        } catch (e: Exception) {
            e.printStackTrace()
            when (e) {
                is InvalidTokenException,
                is ExpiredTokenException,
                is UnexpectedTokenException -> throw e
                else -> throw UnexpectedTokenException
            }
        }
    }

    private fun getClaims(token: String): Jws<Claims> {
        return try {
            Jwts.parserBuilder()
                .setSigningKey(securityProperties.getSigningKey())
                .build()
                .parseClaimsJws(token)
        } catch (e: Exception) {
            when (e) {
                is InvalidClaimException -> throw InvalidTokenException
                is ExpiredJwtException -> throw ExpiredTokenException
                is JwtException -> throw UnexpectedTokenException
                else -> {
                    e.printStackTrace()
                    throw InternalServerErrorException
                }
            }
        }
    }

    private fun getDetails(body: Claims): UserDetails {
        try {
            println("JwtProperties.ACCESS: ${JwtProperties.ACCESS}")
            println("JwtProperties.AUTHORITY: ${JwtProperties.AUTHORITY}")
            val authority = body.get(JwtProperties.AUTHORITY, String::class.java)
                ?: throw InvalidTokenException

            val userId = body.get("id", String::class.java)
                ?: throw InvalidTokenException

            return when (authority) {
                Authority.STAFF.name -> studentDetailsService.loadUserByUsername(userId)
                Authority.MANAGER.name-> managerDetailsService.loadUserByUsername(userId)
                else -> throw UnexpectedTokenException
            }
        } catch (e: Exception) {
            e.printStackTrace()
            if (e is InvalidTokenException || e is UnexpectedTokenException) {
                throw e
            }
            throw UnexpectedTokenException
        }
    }
}