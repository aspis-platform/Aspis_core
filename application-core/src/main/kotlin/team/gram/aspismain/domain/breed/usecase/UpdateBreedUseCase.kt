package team.gram.aspismain.domain.breed.usecase

import team.gram.aspismain.domain.breed.model.Breed

fun interface UpdateBreedUseCase {
    fun execute(breed: Breed): Breed
}