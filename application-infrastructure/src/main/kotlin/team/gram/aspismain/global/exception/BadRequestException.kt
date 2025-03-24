package team.gram.aspismain.global.exception

import team.gram.aspismain.common.error.AspisException
import team.gram.aspismain.global.exception.error.GlobalErrorCode

object BadRequestException : AspisException( GlobalErrorCode.BAD_REQUEST )