package team.gram.aspismain.domain.breed.service

import org.springframework.stereotype.Service
import team.gram.aspismain.domain.breed.model.Breed
import team.gram.aspismain.domain.breed.spi.BreedPort
import java.util.UUID

@Service
class BreedQueryServiceImpl(
    private val breedPort: BreedPort
) : BreedQueryService {
    override fun getBreedById(breedId: UUID): Breed? {
        return breedPort.getBreedById(breedId)
    }
    
    override fun getAllBreeds(): List<Breed> {
        return breedPort.getAllBreeds()
    }
}