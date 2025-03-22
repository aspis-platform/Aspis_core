package team.gram.aspismain.global.security

import io.jsonwebtoken.security.Keys
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import java.util.Base64
import javax.crypto.SecretKey

@Component
@ConfigurationProperties(prefix = "secret")
class SecurityProperties {
    lateinit var secretKey: String
    lateinit var accessExp: Number
    lateinit var refreshExp: Number

    fun getSigningKey(): SecretKey {
        return Keys.hmacShaKeyFor(
            Base64.getEncoder().encodeToString(secretKey.toByteArray())
                .toByteArray(Charsets.UTF_8)
        )
    }
}