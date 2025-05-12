package team.gram.aspismain.domain.weight.service

import team.gram.aspismain.domain.weight.model.Weight
import java.util.UUID

interface WeightCommandService {
    fun saveWeight(weight: Weight): Weight
    fun updateWeight(weightId: UUID, newWeight: Int, newDate: java.util.Date): Weight
    fun deleteWeight(weightId: UUID)
}