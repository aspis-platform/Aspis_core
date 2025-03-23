package team.gram.aspismain.global.exception

import team.gram.aspismain.global.exception.config.AspisException
import team.gram.aspismain.global.exception.error.GlobalExceptionCode

object BadRequestException : AspisException(
    GlobalExceptionCode.BAD_REQUEST
)