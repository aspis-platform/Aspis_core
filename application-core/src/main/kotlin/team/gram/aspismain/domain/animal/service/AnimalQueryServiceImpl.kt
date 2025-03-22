package team.gram.aspismain.domain.animal.service

import org.springframework.stereotype.Service
import team.gram.aspismain.domain.animal.model.Animal
import team.gram.aspismain.domain.animal.spi.AnimalPort
import java.util.UUID

@Service
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