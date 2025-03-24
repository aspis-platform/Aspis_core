package team.gram.aspismain.global.security.exception.error

import team.gram.aspismain.common.error.ErrorResponse

enum class SecurityExceptionCode(
    override val status: Int,
    override val message: String,
    override val sequence : String,
) : ErrorResponse {
    EXPIRED_TOKEN(401, "Expired token","SE-1"),
    INVALID_TOKEN(401, "Invalid token","SE-2"),
    UNEXPECTED_TOKEN(401, "Unexpected token","SE-3"),
    FORBIDDEN_ACCESS(403, "No permission","SE-1"),
}