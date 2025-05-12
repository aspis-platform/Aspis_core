package team.gram.aspismain.domain.weight.dto

import java.util.Date
import java.util.UUID

data class UpdateWeightRequest(
    val weightId: UUID,
    val weight: Int,
    val date: Date = Date()
)