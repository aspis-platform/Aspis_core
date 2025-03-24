package team.gram.aspismain.global.exception.config

import team.gram.aspismain.common.error.ErrorResponse

data class DefaultErrorResponse(
    override val status: Int,
    override val message: String,
    override val sequence: String
) : ErrorResponse
