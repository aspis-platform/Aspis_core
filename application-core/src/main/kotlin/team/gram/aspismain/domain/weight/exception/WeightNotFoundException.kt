package team.gram.aspismain.domain.animal.exception

import team.gram.aspismain.common.error.AspisException
import team.gram.aspismain.domain.weight.exception.error.WeightExceptionCode

object WeightNotFoundException : AspisException( WeightExceptionCode.WEIGHT_HISTORY_NOT_FOUND )