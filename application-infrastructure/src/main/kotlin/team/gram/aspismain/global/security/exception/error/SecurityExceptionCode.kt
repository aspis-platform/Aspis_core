package team.gram.aspismain.global.security.exception.error

import team.gram.aspismain.global.exception.config.ErrorStatusCode
import team.gram.aspismain.global.exception.config.ErrorProperty

enum class SecurityExceptionCode (
    private val status: Int,
    private val message: String,
    private val sequence: Int
) : ErrorProperty {

    INVALID_TOKEN(ErrorStatusCode.UNAUTHORIZED, "Not a valid token", 1),
    EXPIRED_TOKEN(ErrorStatusCode.UNAUTHORIZED, "Expired token", 2),
    NOT_EXPECTED_TOKEN(ErrorStatusCode.UNAUTHORIZED,"Not a excepted token",3),
    NOT_EXPECTED_ROLE(ErrorStatusCode.FORBIDDEN,"Not a excepted role",1),
    FORBIDDEN_ACCESS(ErrorStatusCode.FORBIDDEN,"No permission to access",2);

    override fun status(): Int = status
    override fun message(): String = message
    override fun code(): String = "$status-$sequence"
}