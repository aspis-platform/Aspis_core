package team.gram.aspismain.domain.animal.usecase

import team.gram.aspismain.common.annotation.UseCase
import team.gram.aspismain.domain.animal.service.AnimalCommandService
import java.util.UUID

@UseCase
class DeleteAnimalUseCase(
    private val animalCommandService: AnimalCommandService
) {
    fun execute(animalId: UUID) {
        animalCommandService.deleteAnimal(animalId)
    }
}