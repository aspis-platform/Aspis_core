package team.gram.aspismain.domain.animal.exception.error

import team.gram.aspismain.global.exception.config.ErrorStatusCode
import team.gram.aspismain.global.exception.config.ErrorProperty

enum class AnimalExceptionCode (
    private val status: Int,
    private val message: String,
    private val sequence: Int
) : ErrorProperty {

    ANIMAL_NOT_FOUND(ErrorStatusCode.NOT_FOUND, "No animal found", 1),

    ;
    override fun status(): Int = status
    override fun message(): String = message
    override fun code(): String = "$status-$sequence"
}