package team.gram.aspismain.domain.animal.dto.response

import team.gram.aspismain.domain.animal.repository.entity.Animal
import team.gram.aspismain.domain.animal.repository.entity.Gender
import team.gram.aspismain.domain.animal.repository.entity.AnimalStatus

data class AnimalInfoResponse(
    val animalId: String,
    val animalName: String,
    val admissionDate: String,
    val animalGender: Gender,
    val animalStatus: AnimalStatus,
    val isNeutered: Boolean,
    val profileUrl: String,
    val isVaccinated: Boolean
)