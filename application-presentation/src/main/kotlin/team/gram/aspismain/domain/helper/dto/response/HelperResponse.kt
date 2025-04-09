package team.gram.aspismain.domain.helper.dto.response

import team.gram.aspismain.domain.helper.model.Helper
import java.util.UUID

data class HelperResponse(
    val id: UUID,
    val name: String,
    val phoneNumber: String,
    val address: String
) {
    companion object {
        fun fromModel(helper: Helper): HelperResponse {
            return HelperResponse(
                id = helper.id,
                name = helper.name,
                phoneNumber = helper.phoneNumber,
                address = helper.address
            )
        }
    }
}