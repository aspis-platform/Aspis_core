package team.gram.aspismain.domain.animal.service

import team.gram.aspismain.domain.animal.model.Animal
import java.util.UUID

interface AnimalQueryService {
    fun getAllAnimals(): List<Animal>
    fun getAnimalById(animalId: UUID): Animal?
}