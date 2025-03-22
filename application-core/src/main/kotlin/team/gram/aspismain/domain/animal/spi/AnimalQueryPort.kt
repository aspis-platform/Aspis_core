package team.gram.aspismain.domain.animal.spi

import team.gram.aspismain.domain.animal.model.Animal
import java.util.*

interface AnimalQueryPort {
    fun getAllAnimal(): List<Animal>

    fun getAnimalById(animalId: UUID) : Animal?
}