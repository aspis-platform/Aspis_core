package team.gram.aspismain.domain.weight.dto

import team.gram.aspismain.domain.weight.model.Weight
import java.text.SimpleDateFormat
import java.util.Date
import java.util.UUID

data class WeightResponse(
    val id: UUID,
    val animalId: UUID,
    val weight: Int,
    val date: String
) {
    companion object {
        fun of(weight: Weight): WeightResponse {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd")
            return WeightResponse(
                id = weight.id,
                animalId = weight.animalId,
                weight = weight.weight,
                date = dateFormat.format(weight.date)
            )
        }
    }
}