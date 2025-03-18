package team.gram.aspismain.global.security.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.Header
import org.springframework.stereotype.Component
import team.gram.aspismain.global.security.SecurityProperties
import team.gram.team.gram.aspismain.domain.auth.model.Authority
import java.util.*

@Component
class JwtProvider(
    private val securityProperties: SecurityProperties
) {

    fun generateAccessToken(id: String, authority: Authority): String {
        return Jwts.builder()
            .setHeaderParam(Header.JWT_TYPE, JwtProperties.ACCESS)
            .setId(id)
            .claim(JwtProperties.AUTHORITY, authority.name)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + securityProperties.accessExp))
            .signWith(securityProperties.secretKey)
            .compact()
    }

    fun generateRefreshToken(id: String, authority: Authority): String {
        return Jwts.builder()
            .setHeaderParam(Header.JWT_TYPE, JwtProperties.REFRESH)
            .setId(id)
            .claim(JwtProperties.AUTHORITY, authority.name)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + securityProperties.refreshExp))
            .signWith(securityProperties.secretKey)
            .compact()
    }
}