package team.gram.aspismain.domain.weight.usecase

import team.gram.aspismain.common.annotation.UseCase
import team.gram.aspismain.domain.weight.dto.SaveWeightRequest
import team.gram.aspismain.domain.weight.dto.WeightResponse
import team.gram.aspismain.domain.weight.service.WeightCommandService

@UseCase
class SaveWeightUseCase(
    private val weightCommandService: WeightCommandService
) {
    fun execute(request: SaveWeightRequest): WeightResponse {
        val savedWeight = weightCommandService.saveWeight(request.toEntity())
        return WeightResponse.of(savedWeight)
    }
}