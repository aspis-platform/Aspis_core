package team.gram.aspismain.domain.animal

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import team.gram.aspismain.domain.animal.dto.AnimalResponse
import team.gram.aspismain.domain.animal.dto.AnimalsResponse
import team.gram.aspismain.domain.animal.dto.request.AnimalRequest
import team.gram.aspismain.domain.animal.usecase.*
import java.util.UUID

@Validated
@RestController
@RequestMapping("/v1/animal")
class AnimalWebAdapter(
    private val getAllAnimalsUseCase: GetAllAnimalsUseCase,
    private val getAnimalByIdUseCase: GetAnimalByIdUseCase,
    private val saveAnimalUseCase: SaveAnimalUseCase,
    private val updateAnimalUseCase: UpdateAnimalUseCase,
    private val deleteAnimalUseCase: DeleteAnimalUseCase
) {
    @GetMapping("/get-all")
    fun getAllAnimals(): ResponseEntity<AnimalsResponse> {
        val animals = getAllAnimalsUseCase.execute()
        val response = AnimalsResponse(
            animals = animals.map { AnimalResponse.of(it) }
        )
        return ResponseEntity.ok(response)
    }

    @GetMapping("/{animalId}")
    fun getAnimalById(@PathVariable animalId: UUID): ResponseEntity<AnimalResponse> {
        val animal = getAnimalByIdUseCase.execute(animalId)
            ?: return ResponseEntity.notFound().build()

        val response = AnimalResponse.of(animal)
        return ResponseEntity.ok(response)
    }

    @PostMapping
    fun saveAnimal(@RequestBody @Validated request: AnimalRequest): ResponseEntity<AnimalResponse> {
        val animal = AnimalRequest.toEntity(request)
        val savedAnimal = saveAnimalUseCase.execute(animal)
        val response = AnimalResponse.of(savedAnimal)
        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    @PutMapping("/{animalId}")
    fun updateAnimal(
        @PathVariable animalId: UUID,
        @RequestBody @Validated request: AnimalRequest
    ): ResponseEntity<AnimalResponse> {
        val animal = AnimalRequest.toEntity(request, animalId)
        val updatedAnimal = updateAnimalUseCase.execute(animal)
        val response = AnimalResponse.of(updatedAnimal)
        return ResponseEntity.ok(response)
    }

    @DeleteMapping("/{animalId}")
    fun deleteAnimal(@PathVariable animalId: UUID): ResponseEntity<Void> {
        deleteAnimalUseCase.execute(animalId)
        return ResponseEntity.noContent().build()
    }
}