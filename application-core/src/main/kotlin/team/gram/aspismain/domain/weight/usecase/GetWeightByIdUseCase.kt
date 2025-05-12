package team.gram.aspismain.domain.weight.usecase

import team.gram.aspismain.common.annotation.QueryUseCase
import team.gram.aspismain.domain.animal.exception.WeightNotFoundException
import team.gram.aspismain.domain.weight.dto.WeightResponse
import team.gram.aspismain.domain.weight.service.WeightQueryService
import java.util.UUID

@QueryUseCase
class GetWeightByIdUseCase(
    private val weightQueryService: WeightQueryService
) {
    fun execute(weightId: UUID): WeightResponse {
        val weight = weightQueryService.getWeightById(weightId) ?: throw WeightNotFoundException
        return WeightResponse.of(weight)
    }
}