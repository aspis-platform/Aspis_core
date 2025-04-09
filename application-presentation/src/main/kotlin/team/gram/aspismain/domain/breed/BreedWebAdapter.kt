package team.gram.aspismain.domain.breed

import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import team.gram.aspismain.domain.breed.dto.request.BreedRequest
import team.gram.aspismain.domain.breed.dto.response.BreedResponse
import team.gram.aspismain.domain.breed.usecase.DeleteBreedUseCase
import team.gram.aspismain.domain.breed.usecase.GetAllBreedsUseCase
import team.gram.aspismain.domain.breed.usecase.GetBreedByIdUseCase
import team.gram.aspismain.domain.breed.usecase.SaveBreedUseCase
import team.gram.aspismain.domain.breed.usecase.UpdateBreedUseCase
import java.util.UUID

@Validated
@RestController
@RequestMapping("/v1/breeds")
class BreedWebAdapter(
    private val getAllBreedsUseCase: GetAllBreedsUseCase,
    private val getBreedByIdUseCase: GetBreedByIdUseCase,
    private val saveBreedUseCase: SaveBreedUseCase,
    private val updateBreedUseCase: UpdateBreedUseCase,
    private val deleteBreedUseCase: DeleteBreedUseCase
) {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllBreeds(): List<BreedResponse> {
        val breeds = getAllBreedsUseCase.execute()
        return breeds.map { BreedResponse.fromBreed(it) }
    }

    @GetMapping("/{breedId}")
    @ResponseStatus(HttpStatus.OK)
    fun getBreedById(@PathVariable breedId: UUID): BreedResponse {
        val breed = getBreedByIdUseCase.execute(breedId)
            ?: throw NoSuchElementException("Breed not found with id: $breedId")
        
        return BreedResponse.fromBreed(breed)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveBreed(@RequestBody @Validated request: BreedRequest): BreedResponse {
        val breed = BreedRequest.toEntity(request)
        val savedBreed = saveBreedUseCase.execute(breed)
        return BreedResponse.fromBreed(savedBreed)
    }

    @PutMapping("/{breedId}")
    @ResponseStatus(HttpStatus.OK)
    fun updateBreed(
        @PathVariable breedId: UUID,
        @RequestBody @Validated request: BreedRequest
    ): BreedResponse {
        val breed = BreedRequest.toEntity(request, breedId)
        val updatedBreed = updateBreedUseCase.execute(breed)
        return BreedResponse.fromBreed(updatedBreed)
    }

    @DeleteMapping("/{breedId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBreed(@PathVariable breedId: UUID) {
        deleteBreedUseCase.execute(breedId)
    }
}