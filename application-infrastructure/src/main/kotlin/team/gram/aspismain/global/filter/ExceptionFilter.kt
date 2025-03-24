package team.gram.aspismain.global.filter

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import org.slf4j.LoggerFactory
import team.gram.aspismain.common.error.AspisException
import team.gram.aspismain.common.error.ErrorResponse
import team.gram.aspismain.global.exception.config.DefaultErrorResponse

class ExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    private val logger = LoggerFactory.getLogger(ExceptionFilter::class.java)

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            //logger.error("Exception occurred during request processing: ${e.message}", e)

            when (val rootCause = getRootCause(e)) {
                is AspisException -> {
                    handleAspisException(response, rootCause.errorCode)
                }
                else -> {
                    handleGenericException(response)
                }
            }
        }
    }

    private fun getRootCause(throwable: Throwable): Throwable {
        var cause = throwable

        while (cause.cause != null && cause.cause !== cause) {
            cause = cause.cause!!
        }

        return cause
    }

    private fun handleAspisException(response: HttpServletResponse, errorCode: ErrorResponse) {
        val errorResponse = DefaultErrorResponse(
            status = errorCode.status,
            message = errorCode.message,
            sequence = errorCode.sequence
        )

        sendErrorResponse(response, errorResponse)
    }

    private fun handleGenericException(response: HttpServletResponse) {
        val errorResponse = DefaultErrorResponse(
            status = 500,
            message = "서버 내부 오류가 발생했습니다.",
            sequence = "SERVER-ERR"
        )

        sendErrorResponse(response, errorResponse)
    }

    private fun sendErrorResponse(response: HttpServletResponse, errorResponse: DefaultErrorResponse) {
        try {
            val errorResponseJson = objectMapper.writeValueAsString(errorResponse)

            response.status = errorResponse.status
            response.contentType = MediaType.APPLICATION_JSON_VALUE
            response.characterEncoding = "UTF-8"
            response.writer.write(errorResponseJson)
        } catch (e: Exception) {
            logger.error("Error sending error response: ${e.message}", e)
        }
    }
}