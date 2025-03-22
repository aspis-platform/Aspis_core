package team.gram.aspismain.domain.animal.service

import team.gram.aspismain.domain.animal.model.Animal
import team.gram.aspismain.domain.animal.spi.AnimalPort
import java.util.UUID

class AnimalQueryServiceImpl(
    private val animalPort: AnimalPort
) : AnimalQueryService {

    override fun getAllAnimals(): List<Animal> {
        return animalPort.getAllAnimal()
    }

    override fun getAnimalById(animalId: UUID): Animal? {
        return animalPort.getAnimalById(animalId)
    }
}