package team.gram.aspismain.global.security.exception

import team.gram.aspismain.global.exception.config.AspisException
import team.gram.aspismain.global.security.exception.error.SecurityExceptionCode

object ForbiddenException : AspisException(
    SecurityExceptionCode.FORBIDDEN_ACCESS
)