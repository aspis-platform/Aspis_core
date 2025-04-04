package team.gram.aspismain.domain.breed.model

import java.util.UUID

data class Breed(
    val id: UUID,
    val name: String,
    val size: BreedSize,
)