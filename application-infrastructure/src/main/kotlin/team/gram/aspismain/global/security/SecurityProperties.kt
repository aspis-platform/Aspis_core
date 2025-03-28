package team.gram.aspismain.global.security

import io.jsonwebtoken.security.Keys
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import javax.crypto.SecretKey

@Component
@ConfigurationProperties(prefix = "secret")
class SecurityProperties {
    lateinit var secretKey: String
    var accessExp: Int = 0
    var refreshExp: Int = 0

    fun getSigningKey(): SecretKey {
        return Keys.hmacShaKeyFor(secretKey.toByteArray(StandardCharsets.UTF_8))
    }
}