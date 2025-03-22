package team.gram.aspismain.domain.animal.usecase

import team.gram.aspismain.common.annotation.UseCase
import team.gram.aspismain.domain.animal.model.Animal
import team.gram.aspismain.domain.animal.service.AnimalQueryService

@UseCase
class GetAllAnimalsUseCase(
    private val animalQueryService: AnimalQueryService
) {
    fun execute(): List<Animal> {
        return animalQueryService.getAllAnimals()
    }
}