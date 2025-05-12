package team.gram.aspismain.domain.weight.dto

import team.gram.aspismain.domain.weight.model.Weight
import java.util.Date
import java.util.UUID

data class SaveWeightRequest(
    val animalId: UUID,
    val weight: Int,
    val date: Date = Date()
) {
    fun toEntity(): Weight {
        return Weight(
            id = UUID.randomUUID(),
            animalId = animalId,
            weight = weight,
            date = date
        )
    }
}