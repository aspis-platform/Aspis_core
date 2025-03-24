package team.gram.aspismain.global.security.exception

import team.gram.aspismain.common.error.AspisException
import team.gram.aspismain.global.security.exception.error.SecurityExceptionCode

object ForbiddenException : AspisException( SecurityExceptionCode.FORBIDDEN_ACCESS )