package team.gram.aspismain.global.security.exception

import team.gram.aspismain.global.exception.config.AspisException
import team.gram.aspismain.global.security.exception.error.SecurityExceptionCode

object InvalidTokenException : AspisException(
    SecurityExceptionCode.INVALID_TOKEN
)