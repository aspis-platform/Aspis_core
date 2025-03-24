package team.gram.aspismain.global.exception

import team.gram.aspismain.common.error.AspisException
import team.gram.aspismain.global.exception.error.GlobalErrorCode

object InternalServerErrorException : AspisException( GlobalErrorCode.INTERNAL_SERVER_ERROR )