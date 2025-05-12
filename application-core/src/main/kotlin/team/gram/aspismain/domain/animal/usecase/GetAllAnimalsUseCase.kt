package team.gram.aspismain.domain.animal.usecase

import team.gram.aspismain.common.annotation.QueryUseCase
import team.gram.aspismain.domain.animal.dto.AnimalResponse
import team.gram.aspismain.domain.animal.model.Animal
import team.gram.aspismain.domain.animal.service.AnimalQueryService
import team.gram.aspismain.domain.breed.service.BreedQueryService
import team.gram.aspismain.domain.helper.service.HelperQueryService
import team.gram.aspismain.domain.weight.dto.WeightResponse
import team.gram.aspismain.domain.weight.service.WeightQueryService

@QueryUseCase
class GetAllAnimalsUseCase(
    private val animalQueryService: AnimalQueryService,
    private val breedQueryService: BreedQueryService,
    private val helperQueryService: HelperQueryService,
    private val weightQueryService: WeightQueryService
) {
    fun execute(): List<Animal> {
        return animalQueryService.getAllAnimals()
    }
    
    fun executeWithDetails(): List<AnimalResponse> {
        val animals = animalQueryService.getAllAnimals()
        
        return animals.map { animal ->
            val breed = breedQueryService.getBreedById(animal.breedId)
            val helper = animal.helperId?.let { helperQueryService.getHelperById(it) }
            
            // 해당 동물의 최신 몸무게 정보만 조회
            val latestWeight = weightQueryService.getWeightsByAnimalId(animal.id)
                .map { WeightResponse.of(it) }
                .firstOrNull()
            
            AnimalResponse.of(
                animal = animal,
                breedName = breed?.name ?: "알 수 없음",
                breedSize = breed?.size ?: team.gram.aspismain.domain.breed.model.BreedSize.MIDDLE,
                helperName = helper?.name ?: "없음",
                latestWeight = latestWeight
            )
        }
    }
}