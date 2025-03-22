package team.gram.aspismain.persistence.animal

import org.springframework.stereotype.Component
import team.gram.aspismain.domain.animal.model.Animal
import team.gram.aspismain.domain.animal.spi.AnimalPort
import team.gram.aspismain.persistence.animal.mapper.AnimalMapper
import team.gram.aspismain.persistence.animal.repository.AnimalJpaRepository
import java.util.UUID

@Component
class AnimalPersistenceAdapter(
    private val animalRepository: AnimalJpaRepository,
    private val animalMapper: AnimalMapper
):AnimalPort {
    override fun saveAnimal(animal: Animal): Animal {
        val e = animalRepository.save(
            animalMapper.toEntity(animal)
        )
        return animalMapper.toDomain(e)!!
    }

    override fun deleteAnimalById(animalId : UUID) {
        animalRepository.deleteById(animalId)
    }

    override fun updateAnimal(animal: Animal): Animal {
        val entity = animalMapper.toEntity(animal)
        val savedEntity = animalRepository.save(entity)
        return animalMapper.toDomain(savedEntity)!!
    }

    override fun getAllAnimal(): List<Animal> {
        return animalRepository.findAll().mapNotNull { animalMapper.toDomain(it) }
    }

    override fun getAnimalById(animalId: UUID): Animal? {
        return animalRepository.findById(animalId)
            .map { animalMapper.toDomain(it) }
            .orElse(null)
    }
}