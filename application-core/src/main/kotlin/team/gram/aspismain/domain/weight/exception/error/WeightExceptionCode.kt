package team.gram.aspismain.domain.weight.exception.error

import team.gram.aspismain.common.error.ErrorResponse

enum class WeightExceptionCode(
    override val status: Int,
    override val message: String,
    override val sequence : String,
) : ErrorResponse {
    WEIGHT_VALUE_NOT_VALID(400, "Not a valid weight value","WEIGHT-1"),
    WEIGHT_HISTORY_NOT_FOUND(404, "Weight history not found","WEIGHT-2"),
}