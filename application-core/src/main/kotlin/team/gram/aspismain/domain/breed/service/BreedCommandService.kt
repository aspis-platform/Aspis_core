package team.gram.aspismain.domain.breed.service

import team.gram.aspismain.domain.breed.model.Breed
import java.util.UUID

interface BreedCommandService {
    fun saveBreed(breed: Breed): Breed
    fun updateBreed(breed: Breed): Breed
    fun deleteBreed(breedId: UUID)
}