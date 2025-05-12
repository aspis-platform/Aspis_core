package team.gram.aspismain.domain.animal

import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import team.gram.aspismain.domain.animal.dto.AnimalResponse
import team.gram.aspismain.domain.animal.dto.request.AnimalRequest
import team.gram.aspismain.domain.animal.usecase.*
import team.gram.aspismain.domain.breed.service.BreedQueryService
import team.gram.aspismain.domain.helper.service.HelperQueryService
import team.gram.aspismain.domain.weight.service.WeightQueryService
import java.util.UUID

@Validated
@RestController
@RequestMapping("/v1/animals")
class AnimalWebAdapter(
    private val getAllAnimalsUseCase: GetAllAnimalsUseCase,
    private val getAnimalByIdUseCase: GetAnimalByIdUseCase,
    private val saveAnimalUseCase: SaveAnimalUseCase,
    private val updateAnimalUseCase: UpdateAnimalUseCase,
    private val deleteAnimalUseCase: DeleteAnimalUseCase,
    private val breedQueryService: BreedQueryService,
    private val helperQueryService: HelperQueryService,
    private val weightQueryService: WeightQueryService
) {
    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    fun getAllAnimals(): List<AnimalResponse> {
        // 몸무게 정보가 포함된 상세 정보 반환 메서드 사용
        return getAllAnimalsUseCase.executeWithDetails()
    }

    @GetMapping("/{animalId}")
    @ResponseStatus(HttpStatus.OK)
    fun getAnimalById(@PathVariable animalId: UUID): AnimalResponse {
        // 몸무게 정보가 포함된 상세 정보 반환 메서드 사용
        val animalResponse = getAnimalByIdUseCase.executeWithDetails(animalId)
            ?: throw NoSuchElementException("Animal not found with id: $animalId")
        
        return animalResponse
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveAnimal(@RequestBody @Validated request: AnimalRequest): AnimalResponse {
        val animal = AnimalRequest.toEntity(request)
        val savedAnimal = saveAnimalUseCase.execute(animal)
        return AnimalResponse.of(savedAnimal)
    }

    @PutMapping("/{animalId}")
    @ResponseStatus(HttpStatus.OK)
    fun updateAnimal(
        @PathVariable animalId: UUID,
        @RequestBody @Validated request: AnimalRequest
    ): AnimalResponse {
        val animal = AnimalRequest.toEntity(request, animalId)
        val updatedAnimal = updateAnimalUseCase.execute(animal)
        return AnimalResponse.of(updatedAnimal)
    }

    @DeleteMapping("/{animalId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteAnimal(@PathVariable animalId: UUID) {
        deleteAnimalUseCase.execute(animalId)
    }
}