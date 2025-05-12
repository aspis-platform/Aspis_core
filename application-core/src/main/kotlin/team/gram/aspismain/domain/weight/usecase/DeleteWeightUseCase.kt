package team.gram.aspismain.domain.weight.usecase

import team.gram.aspismain.common.annotation.UseCase
import team.gram.aspismain.domain.weight.service.WeightCommandService
import java.util.UUID

@UseCase
class DeleteWeightUseCase(
    private val weightCommandService: WeightCommandService
) {
    fun execute(weightId: UUID) {
        weightCommandService.deleteWeight(weightId)
    }
}