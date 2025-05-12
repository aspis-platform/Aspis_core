package team.gram.aspismain.domain.animal.dto

import team.gram.aspismain.domain.animal.model.Animal
import team.gram.aspismain.domain.animal.model.AnimalSexType
import team.gram.aspismain.domain.animal.model.AnimalStatusType
import team.gram.aspismain.domain.breed.model.BreedSize
import team.gram.aspismain.domain.weight.dto.WeightResponse
import java.util.UUID
import java.util.Date

data class AnimalResponse(
    val id: UUID,
    val name: String,
    val breedId: UUID,
    val breedInfo: BreedInfo? = null,
    val sex: AnimalSexType,
    val animalStatus: AnimalStatusType,
    val helperId: UUID?,
    val admissionDate: String,
    val helperName: String? = null,
    val profileUrl: String,
    val isNeutered: Boolean,
    val birthYear: Int,
    val latestWeight: WeightResponse? = null
) {
    data class BreedInfo(
        val breedName: String,
        val breedSize: BreedSize
    )
    
    companion object {
        fun of(animal: Animal): AnimalResponse {
            return AnimalResponse(
                id = animal.id,
                name = animal.name,
                breedId = animal.breedId,
                isNeutered = animal.isNeutered,
                sex = animal.sex,
                animalStatus = animal.animalStatus,
                profileUrl = animal.profileUrl,
                helperId = animal.helperId,
                birthYear = animal.birthYear,
                admissionDate = animal.admissionDate.toString()
            )
        }

        fun of(animal: Animal, breedName: String, breedSize: BreedSize, helperName: String): AnimalResponse {
            return AnimalResponse(
                id = animal.id,
                name = animal.name,
                breedId = animal.breedId,
                breedInfo = BreedInfo(breedName, breedSize),
                isNeutered = animal.isNeutered,
                sex = animal.sex,
                animalStatus = animal.animalStatus,
                profileUrl = animal.profileUrl,
                helperId = animal.helperId,
                helperName = helperName,
                birthYear = animal.birthYear,
                admissionDate = animal.admissionDate.toString()
            )
        }
        
        fun of(animal: Animal, breedName: String, breedSize: BreedSize, helperName: String, 
               latestWeight: WeightResponse?): AnimalResponse {
            return AnimalResponse(
                id = animal.id,
                name = animal.name,
                breedId = animal.breedId,
                breedInfo = BreedInfo(breedName, breedSize),
                isNeutered = animal.isNeutered,
                sex = animal.sex,
                animalStatus = animal.animalStatus,
                profileUrl = animal.profileUrl,
                helperId = animal.helperId,
                helperName = helperName,
                birthYear = animal.birthYear,
                admissionDate = animal.admissionDate.toString(),
                latestWeight = latestWeight
            )
        }
    }
}