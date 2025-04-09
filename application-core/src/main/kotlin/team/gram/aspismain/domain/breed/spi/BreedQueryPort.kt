package team.gram.aspismain.domain.breed.spi

import team.gram.aspismain.domain.breed.model.Breed
import java.util.UUID

interface BreedQueryPort {
    fun getBreedById(breedId: UUID): Breed?
    fun getAllBreeds(): List<Breed>
}