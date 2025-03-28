package team.gram.aspismain.domain.animal.model

import java.util.Date
import java.util.UUID

data class Animal(
    val id: UUID,
    val breedId: UUID,
    val helperId: UUID,
    val name: String,
    val isNeutered: Boolean,
    val sex: AnimalSexType,
    val animalStatus: AnimalStatusType,
    val birthYear: Int,
    val profile_url: String,
)