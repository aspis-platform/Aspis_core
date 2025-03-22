package team.gram.aspismain.domain.animal.usecase

import team.gram.aspismain.common.annotation.UseCase
import team.gram.aspismain.domain.animal.model.Animal
import team.gram.aspismain.domain.animal.service.AnimalCommandService

@UseCase
class SaveAnimalUseCase(
    private val animalCommandService: AnimalCommandService
) {
    fun execute(animal: Animal): Animal {
        return animalCommandService.saveAnimal(animal)
    }
}