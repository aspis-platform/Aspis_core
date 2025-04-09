package team.gram.aspismain.domain.breed.service

import team.gram.aspismain.domain.breed.model.Breed
import java.util.UUID

interface BreedQueryService {
    fun getBreedById(breedId: UUID): Breed?
    fun getAllBreeds(): List<Breed>
}