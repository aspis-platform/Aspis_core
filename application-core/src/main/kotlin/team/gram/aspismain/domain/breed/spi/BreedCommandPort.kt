package team.gram.aspismain.domain.breed.spi

import team.gram.aspismain.domain.breed.model.Breed
import java.util.UUID

interface BreedCommandPort {
    fun saveBreed(breed: Breed): Breed
    fun updateBreed(breed: Breed): Breed
    fun deleteBreed(breedId: UUID)
}