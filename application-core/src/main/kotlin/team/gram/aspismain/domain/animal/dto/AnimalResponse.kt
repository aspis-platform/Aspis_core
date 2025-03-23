package team.gram.aspismain.domain.animal.dto

import team.gram.aspismain.domain.animal.model.Animal
import team.gram.aspismain.domain.animal.model.AnimalSexType
import team.gram.aspismain.domain.animal.model.AnimalStatusType
import java.util.UUID
import java.util.Date

data class AnimalResponse(
    val id: UUID,
    val name: String,
    val breedId: UUID,
    val admissionDate: Date,
    val sex: AnimalSexType,
    val animalStatus: AnimalStatusType,
    val profileUrl: String
) {
    companion object {
        fun of(animal: Animal): AnimalResponse {
            return AnimalResponse(
                id = animal.id,
                name = animal.name,
                breedId = animal.breedId,
                admissionDate = animal.admissionDate,
                sex = animal.sex,
                animalStatus = animal.animalStatus,
                profileUrl = animal.profile_url
            )
        }
    }
}