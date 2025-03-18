package team.gram.aspismain.global.exception.error

import team.gram.aspismain.global.exception.config.ErrorStatusCode
import team.gram.aspismain.global.exception.config.ErrorProperty

enum class GlobalExceptionCode (
    private val status: Int,
    private val message: String,
    private val sequence: Int
) : ErrorProperty {

    BAD_REQUEST(ErrorStatusCode.BAD_REQUEST, "Bad Request", 1),

    INTERNAL_SERVER_ERROR(ErrorStatusCode.INTERNAL_SERVER_ERROR, "Internal Server Error", 1);

    override fun status(): Int = status
    override fun message(): String = message
    override fun code(): String = "$status-$sequence"
}