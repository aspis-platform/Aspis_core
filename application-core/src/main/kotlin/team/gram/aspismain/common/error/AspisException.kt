package team.gram.aspismain.common.error

import team.gram.aspismain.domain.animal.exception.error.AnimalExceptionCode

abstract class AspisException(
    val errorProperty: AnimalExceptionCode
) : RuntimeException()