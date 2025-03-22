package team.gram.aspismain.domain.animal.usecase

import team.gram.aspismain.domain.animal.model.Animal
import team.gram.aspismain.domain.animal.service.AnimalCommandService

class UpdateAnimalUseCase(
    private val animalCommandService: AnimalCommandService
) {
    fun execute(animal: Animal): Animal {
        return animalCommandService.updateAnimal(animal)
    }
}