package team.gram.aspismain.domain.breed.usecase

import java.util.UUID

fun interface DeleteBreedUseCase {
    fun execute(breedId: UUID)
}