package team.gram.aspismain.common.error

interface ErrorResponse {
    val status: Int
    val message: String
    val sequence: String
}