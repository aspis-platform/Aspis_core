package team.gram.aspismain.domain.animal.exception

import team.gram.aspismain.common.error.AspisException
import team.gram.aspismain.domain.weight.exception.error.WeightExceptionCode

object InvalidWeightException : AspisException( WeightExceptionCode.WEIGHT_VALUE_NOT_VALID )