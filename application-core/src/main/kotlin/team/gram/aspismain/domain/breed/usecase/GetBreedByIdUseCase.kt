package team.gram.aspismain.domain.breed.usecase

import team.gram.aspismain.domain.breed.model.Breed
import java.util.UUID

fun interface GetBreedByIdUseCase {
    fun execute(breedId: UUID): Breed?
}