package team.gram.aspismain.domain.animal.service

import team.gram.aspismain.domain.animal.model.Animal
import team.gram.aspismain.domain.animal.spi.AnimalPort
import java.util.UUID

class AnimalCommandServiceImpl(
    private val animalPort: AnimalPort
) : AnimalCommandService {

    override fun saveAnimal(animal: Animal): Animal {
        return animalPort.saveAnimal(animal)
    }

    override fun updateAnimal(animal: Animal): Animal {
        return animalPort.updateAnimal(animal)
    }

    override fun deleteAnimal(animalId: UUID) {
        animalPort.deleteAnimalById(animalId)
    }
}