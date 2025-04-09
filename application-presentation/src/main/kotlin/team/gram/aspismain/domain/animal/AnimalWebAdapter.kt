package team.gram.aspismain.domain.animal

import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import team.gram.aspismain.domain.animal.dto.AnimalResponse
import team.gram.aspismain.domain.animal.dto.request.AnimalRequest
import team.gram.aspismain.domain.animal.usecase.*
import team.gram.aspismain.domain.breed.service.BreedQueryService
import team.gram.aspismain.domain.helper.service.HelperQueryService
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
    private val breedQueryService: BreedQueryService,  // 추가
    private val helperQueryService: HelperQueryService  // 추가
) {
    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    fun getAllAnimals(): List<AnimalResponse> {
        val animals = getAllAnimalsUseCase.execute()
        return animals.map { animal ->
            val breed = breedQueryService.getBreedById(animal.breedId)
            val helperName = animal.helperId?.let { helperQueryService.getHelperNameById(it) } ?: "Unknown"
            
            if (breed != null) {
                AnimalResponse.of(animal, breed.name, breed.size, helperName)
            } else {
                val response = AnimalResponse.of(animal)
                response.copy(helperName = helperName)
            }
        }
    }

    @GetMapping("/{animalId}")
    @ResponseStatus(HttpStatus.OK)
    fun getAnimalById(@PathVariable animalId: UUID): AnimalResponse {
        val animal = getAnimalByIdUseCase.execute(animalId)
            ?: throw NoSuchElementException("Animal not found with id: $animalId")

        val breed = breedQueryService.getBreedById(animal.breedId)
        val helperName = animal.helperId?.let { helperQueryService.getHelperNameById(it) } ?: "Unknown"
        
        return if (breed != null) {
            AnimalResponse.of(animal, breed.name, breed.size, helperName)
        } else {
            val response = AnimalResponse.of(animal)
            response.copy(helperName = helperName)
        }
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