package team.gram.aspismain.global.exception.config

abstract class AspisException(
    val errorProperty: ErrorProperty
) : RuntimeException()