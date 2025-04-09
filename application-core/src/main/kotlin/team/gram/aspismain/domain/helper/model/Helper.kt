package team.gram.aspismain.domain.helper.model

import java.util.UUID

data class Helper(
    val id: UUID,
    val name: String,
    val phoneNumber: String,
    val address: String
)