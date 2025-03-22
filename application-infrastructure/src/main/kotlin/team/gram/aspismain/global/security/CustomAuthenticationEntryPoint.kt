package team.gram.aspismain.global.security

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import team.gram.aspismain.global.security.exception.error.SecurityExceptionCode

@Component
class CustomAuthenticationEntryPoint(
    private val objectMapper: ObjectMapper
) : AuthenticationEntryPoint {

    override fun commence(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authException: AuthenticationException?
    ) {
        val errorCode = SecurityExceptionCode.FORBIDDEN_ACCESS

        response?.status = errorCode.status()
        response?.contentType = MediaType.APPLICATION_JSON_VALUE
        response?.characterEncoding = "UTF-8"

        val errorResponse = mapOf(
            "status" to errorCode.status(),
            "code" to errorCode.code(),
            "message" to errorCode.message()
        )

        response?.writer?.write(objectMapper.writeValueAsString(errorResponse))
    }
}