package team.gram.aspismain.domain.breed.service

import org.springframework.stereotype.Service
import team.gram.aspismain.domain.breed.model.Breed
import team.gram.aspismain.domain.breed.spi.BreedCommandPort
import java.util.UUID

@Service
class BreedCommandServiceImpl(
    private val breedCommandPort: BreedCommandPort
) : BreedCommandService {
    override fun saveBreed(breed: Breed): Breed {
        return breedCommandPort.saveBreed(breed)
    }

    override fun updateBreed(breed: Breed): Breed {
        return breedCommandPort.updateBreed(breed)
    }

    override fun deleteBreed(breedId: UUID) {
        breedCommandPort.deleteBreed(breedId)
    }
}