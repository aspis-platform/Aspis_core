package team.gram.aspismain.domain.animal.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import team.gram.aspismain.domain.animal.model.Animal
import team.gram.aspismain.domain.animal.model.AnimalSexType
import team.gram.aspismain.domain.animal.model.AnimalStatusType
import java.util.Date
import java.util.UUID

data class AnimalRequest(
    @field:NotBlank
    val name: String,

    @field:NotNull
    val breedId: UUID,

    @field:NotNull
    val helperId: UUID,

    @field:NotNull
    val sex: AnimalSexType,

    @field:NotNull
    val isNeutered :Boolean,

    @field:NotNull
    val animalStatus: AnimalStatusType,

    @field:NotNull
    val birthYear: Int,

    val profileUrl: String
) {
    companion object {
        fun toEntity(request: AnimalRequest, id: UUID = UUID.randomUUID()): Animal {
            return Animal(
                id = id,
                name = request.name,
                breedId = request.breedId,
                helperId = request.helperId,
                sex = request.sex,
                animalStatus = request.animalStatus,
                profileUrl = request.profileUrl,
                birthYear = request.birthYear,
                isNeutered = request.isNeutered
            )
        }
    }
}