package team.gram.aspismain.domain.animal.spi

import team.gram.aspismain.domain.animal.model.Animal
import java.util.UUID

interface AnimalCommandPort{
    fun saveAnimal(animal: Animal): Animal

    fun deleteAnimalById(animalId: UUID)

    fun updateAnimal(animal: Animal) : Animal
}