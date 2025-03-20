package team.gram.aspismain.domain.animal.exception

import team.gram.aspismain.domain.animal.exception.error.AnimalExceptionCode
import team.gram.aspismain.global.exception.config.AspisException
import team.gram.aspismain.global.exception.error.GlobalExceptionCode

object AnimalNotFoundException :AspisException(
    AnimalExceptionCode.ANIMAL_NOT_FOUND
)