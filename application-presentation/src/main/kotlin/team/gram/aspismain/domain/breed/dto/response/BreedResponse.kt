package team.gram.aspismain.domain.breed.dto.response

import team.gram.aspismain.domain.breed.model.Breed
import team.gram.aspismain.domain.breed.model.BreedSize
import java.util.UUID

data class BreedResponse(
    val id: UUID,
    val name: String,
    val size: BreedSize
) {
    companion object {
        fun fromBreed(breed: Breed): BreedResponse {
            return BreedResponse(
                id = breed.id,
                name = breed.name,
                size = breed.size
            )
        }
    }
}