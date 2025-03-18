package team.gram.aspismain.global.exception

data class ValidationErrorResponse(
    val status: Int,
    val fieldError: Map<String, String?>
)