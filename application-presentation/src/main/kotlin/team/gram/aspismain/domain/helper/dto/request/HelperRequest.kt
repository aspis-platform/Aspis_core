package team.gram.aspismain.domain.helper.dto.request

import team.gram.aspismain.domain.helper.model.Helper
import java.util.UUID

data class HelperRequest(
    val name: String,
    val phoneNumber: String,
    val address: String
) {
    companion object {
        fun toModel(request: HelperRequest, id: UUID? = null): Helper {
            return Helper(
                id = id ?: UUID.randomUUID(),
                name = request.name,
                phoneNumber = request.phoneNumber,
                address = request.address
            )
        }
    }
}