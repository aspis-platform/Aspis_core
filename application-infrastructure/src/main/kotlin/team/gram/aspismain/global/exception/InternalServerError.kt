package team.gram.aspismain.global.exception

import team.gram.aspismain.global.exception.config.AspisException
import team.gram.aspismain.global.exception.error.GlobalExceptionCode

object InternalServerError :AspisException(
    GlobalExceptionCode.INTERNAL_SERVER_ERROR
)