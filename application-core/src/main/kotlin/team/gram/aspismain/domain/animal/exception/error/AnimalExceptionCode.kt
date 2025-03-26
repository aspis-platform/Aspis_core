package team.gram.aspismain.domain.animal.exception.error

import team.gram.aspismain.common.error.ErrorResponse

enum class AnimalExceptionCode(
    override val status: Int,
    override val message: String,
    override val sequence : String,
) : ErrorResponse {
    ANIMAL_NOT_FOUND(404, "No animal found","ANIMAL-1"),
    ANIMAL_ALREADY_EXISTS(409, "Already existing animal","ANIMAL-2"),
}