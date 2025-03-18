package team.gram.aspismain.global.security.exception

import team.gram.aspismain.global.exception.config.AspisException
import team.gram.aspismain.global.security.exception.error.SecurityExceptionCode

object UnexceptedException : AspisException(
    SecurityExceptionCode.NOT_EXPECTED_TOKEN
)