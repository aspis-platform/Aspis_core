package team.gram.aspismain.common.error

open class AspisException : RuntimeException {
    val errorCode: ErrorResponse

    constructor(errorCode: ErrorResponse) : super(errorCode.message) {
        this.errorCode = errorCode
    }

    constructor(errorCode: ErrorResponse, message: String) : super(message) {
        this.errorCode = errorCode
    }
}