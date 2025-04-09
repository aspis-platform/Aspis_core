package team.gram.aspismain.persistence.breed.adapter

import org.springframework.stereotype.Component
import team.gram.aspismain.domain.breed.model.Breed
import team.gram.aspismain.domain.breed.spi.BreedPort
import team.gram.aspismain.persistence.breed.mapper.BreedMapper
import team.gram.aspismain.persistence.breed.repository.BreedRepository
import java.util.UUID

@Component
class BreedAdapter(
    private val breedRepository: BreedRepository,
    private val breedMapper: BreedMapper
) : BreedPort {

    override fun saveBreed(breed: Breed): Breed {
        val entity = breedMapper.toEntity(breed)
        val savedEntity = breedRepository.save(entity)
        return breedMapper.toDomain(savedEntity)
    }

    override fun updateBreed(breed: Breed): Breed {
        val entity = breedMapper.toEntity(breed)
        val savedEntity = breedRepository.save(entity)
        return breedMapper.toDomain(savedEntity)
    }

    override fun deleteBreed(breedId: UUID) {
        breedRepository.deleteById(breedId)
    }

    override fun getBreedById(breedId: UUID): Breed? {
        return breedRepository.findById(breedId)
            .map { breedMapper.toDomain(it) }
            .orElse(null)
    }
    
    override fun getAllBreeds(): List<Breed> {
        return breedRepository.findAll().map { breedMapper.toDomain(it) }
    }
}
