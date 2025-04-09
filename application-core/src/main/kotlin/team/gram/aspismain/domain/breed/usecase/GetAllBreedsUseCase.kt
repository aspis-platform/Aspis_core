package team.gram.aspismain.domain.breed.usecase

import team.gram.aspismain.domain.breed.model.Breed

fun interface GetAllBreedsUseCase {
    fun execute(): List<Breed>
}