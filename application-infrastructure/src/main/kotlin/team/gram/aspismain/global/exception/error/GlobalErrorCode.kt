package team.gram.aspismain.global.exception.error

import team.gram.aspismain.common.error.ErrorResponse

enum class GlobalErrorCode(
    override val status: Int,
    override val message: String,
    override val sequence : String,
) : ErrorResponse {
    NOT_FOUND(404, "Not found","GL-1"),
    BAD_REQUEST(400, "Bad Request","GL-1"),
    INTERNAL_SERVER_ERROR(500, "Server error occurred","GL-1")
}