package team.gram.aspismain.domain.animal.exception

import team.gram.aspismain.common.error.AspisException
import team.gram.aspismain.domain.animal.exception.error.AnimalExceptionCode

object AnimalAlreadyExistsException : AspisException( AnimalExceptionCode.ANIMAL_ALREADY_EXISTS )