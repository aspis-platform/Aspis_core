package team.gram.aspismain.domain.breed.usecase

import org.springframework.stereotype.Component
import team.gram.aspismain.domain.breed.model.Breed
import team.gram.aspismain.domain.breed.service.BreedCommandService
import team.gram.aspismain.domain.breed.service.BreedQueryService
import java.util.UUID

@Component
class SaveBreedUseCaseImpl(
    private val breedCommandService: BreedCommandService
) : SaveBreedUseCase {
    override fun execute(breed: Breed): Breed {
        return breedCommandService.saveBreed(breed)
    }
}

@Component
class UpdateBreedUseCaseImpl(
    private val breedCommandService: BreedCommandService
) : UpdateBreedUseCase {
    override fun execute(breed: Breed): Breed {
        return breedCommandService.updateBreed(breed)
    }
}

@Component
class DeleteBreedUseCaseImpl(
    private val breedCommandService: BreedCommandService
) : DeleteBreedUseCase {
    override fun execute(breedId: UUID) {
        breedCommandService.deleteBreed(breedId)
    }
}

@Component
class GetBreedByIdUseCaseImpl(
    private val breedQueryService: BreedQueryService
) : GetBreedByIdUseCase {
    override fun execute(breedId: UUID): Breed? {
        return breedQueryService.getBreedById(breedId)
    }
}

@Component
class GetAllBreedsUseCaseImpl(
    private val breedQueryService: BreedQueryService
) : GetAllBreedsUseCase {
    override fun execute(): List<Breed> {
        return breedQueryService.getAllBreeds()
    }
}