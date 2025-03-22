package team.gram.aspismain.domain.animal.service

import team.gram.aspismain.domain.animal.model.Animal
import java.util.UUID

interface AnimalCommandService {
    fun saveAnimal(animal: Animal): Animal
    fun updateAnimal(animal: Animal): Animal
    fun deleteAnimal(animalId: UUID)
}