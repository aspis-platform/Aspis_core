package team.gram.aspismain.domain.weight.usecase

import team.gram.aspismain.common.annotation.UseCase
import team.gram.aspismain.domain.weight.dto.UpdateWeightRequest
import team.gram.aspismain.domain.weight.dto.WeightResponse
import team.gram.aspismain.domain.weight.service.WeightCommandService

@UseCase
class UpdateWeightUseCase(
    private val weightCommandService: WeightCommandService
) {
    fun execute(request: UpdateWeightRequest): WeightResponse {
        val updatedWeight = weightCommandService.updateWeight(
            weightId = request.weightId,
            newWeight = request.weight,
            newDate = request.date
        )
        return WeightResponse.of(updatedWeight)
    }
}