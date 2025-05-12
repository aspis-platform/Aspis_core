package team.gram.aspismain.domain.weight.usecase

import team.gram.aspismain.common.annotation.QueryUseCase
import team.gram.aspismain.domain.weight.dto.WeightResponse
import team.gram.aspismain.domain.weight.service.WeightQueryService

@QueryUseCase
class GetAllWeightsUseCase(
    private val weightQueryService: WeightQueryService
) {
    fun execute(): List<WeightResponse> {
        return weightQueryService.getAllWeights().map { WeightResponse.of(it) }
    }
}