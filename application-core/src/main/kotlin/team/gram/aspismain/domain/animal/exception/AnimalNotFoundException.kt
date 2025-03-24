package team.gram.aspismain.domain.animal.exception

import team.gram.aspismain.common.error.AspisException
import team.gram.aspismain.domain.animal.exception.error.AnimalExceptionCode

object AnimalNotFoundException : AspisException( AnimalExceptionCode.ANIMAL_NOT_FOUND )