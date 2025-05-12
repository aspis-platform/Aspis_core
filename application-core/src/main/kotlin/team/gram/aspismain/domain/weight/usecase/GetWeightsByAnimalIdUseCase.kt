package team.gram.aspismain.domain.weight.usecase

import team.gram.aspismain.common.annotation.QueryUseCase
import team.gram.aspismain.domain.animal.exception.AnimalNotFoundException
import team.gram.aspismain.domain.animal.service.AnimalQueryService
import team.gram.aspismain.domain.weight.dto.WeightListResponse
import team.gram.aspismain.domain.weight.service.WeightQueryService
import java.util.UUID

@QueryUseCase
class GetWeightsByAnimalIdUseCase(
    private val weightQueryService: WeightQueryService,
    private val animalQueryService: AnimalQueryService
) {
    fun execute(animalId: UUID): WeightListResponse {
        val animal = animalQueryService.getAnimalById(animalId) ?: throw AnimalNotFoundException
        val weights = weightQueryService.getWeightsByAnimalId(animalId)
        
        return WeightListResponse.of(animal, weights)
    }
}