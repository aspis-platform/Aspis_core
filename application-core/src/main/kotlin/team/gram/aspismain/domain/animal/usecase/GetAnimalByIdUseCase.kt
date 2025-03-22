package team.gram.aspismain.domain.animal.usecase

import team.gram.aspismain.domain.animal.model.Animal
import team.gram.aspismain.domain.animal.service.AnimalQueryService
import java.util.UUID

class GetAnimalByIdUseCase(
    private val animalQueryService: AnimalQueryService
) {
    fun execute(animalId: UUID): Animal? {
        return animalQueryService.getAnimalById(animalId)
    }
}