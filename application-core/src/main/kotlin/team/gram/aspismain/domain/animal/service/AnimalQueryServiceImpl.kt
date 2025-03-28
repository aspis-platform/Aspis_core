package team.gram.aspismain.domain.animal.service

import org.springframework.stereotype.Service
import team.gram.aspismain.domain.animal.exception.AnimalNotFoundException
import team.gram.aspismain.domain.animal.model.Animal
import team.gram.aspismain.domain.animal.spi.AnimalPort
import java.util.UUID

@Service
class AnimalQueryServiceImpl(
    private val animalPort: AnimalPort
) : AnimalQueryService {

    override fun getAllAnimals(): List<Animal> {
        val animals = animalPort.getAllAnimal()
        return animals
    }

    override fun getAnimalById(animalId: UUID): Animal? {
        val animal = animalPort.getAnimalById(animalId) ?: throw AnimalNotFoundException
        return animal
    }
}