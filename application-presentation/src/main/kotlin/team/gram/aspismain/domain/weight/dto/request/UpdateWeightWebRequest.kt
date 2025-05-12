package team.gram.aspismain.domain.weight.dto.request

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import team.gram.aspismain.domain.weight.dto.UpdateWeightRequest
import java.util.Date
import java.util.UUID

data class UpdateWeightWebRequest(
    @field:NotNull(message = "무게는 필수입니다.")
    @field:Min(value = 1, message = "무게는 0보다 커야 합니다.")
    val weight: Int,
    
    val date: Date = Date()
) {
    fun toDomainRequest(weightId: UUID): UpdateWeightRequest {
        return UpdateWeightRequest(
            weightId = weightId,
            weight = weight,
            date = date
        )
    }
}