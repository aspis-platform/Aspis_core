package team.gram.aspismain.domain.breed.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import team.gram.aspismain.domain.breed.model.Breed
import team.gram.aspismain.domain.breed.model.BreedSize
import java.util.UUID

data class BreedRequest(
    @field:NotBlank
    val name: String,
    
    @field:NotNull
    val size: BreedSize
) {
    companion object {
        fun toEntity(request: BreedRequest, id: UUID = UUID.randomUUID()): Breed {
            return Breed(
                id = id,
                name = request.name,
                size = request.size
            )
        }
    }
}