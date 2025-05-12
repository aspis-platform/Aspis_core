package team.gram.aspismain.domain.weight.spi

import team.gram.aspismain.domain.weight.model.Weight
import java.util.UUID

interface WeightCommandPort {
    fun saveWeight(weight: Weight): Weight
    fun updateWeight(weight: Weight): Weight
    fun deleteWeightById(weightId: UUID)
}