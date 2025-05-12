package team.gram.aspismain.domain.weight.model

import java.util.Date
import java.util.UUID

data class Weight(
    val id: UUID,
    val animalId: UUID,
    val weight: Int,
    val date: Date
)