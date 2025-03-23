package team.gram.aspismain.global.exception.config

import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.BindException
import org.springframework.validation.BindingResult
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import team.gram.aspismain.global.exception.error.GlobalExceptionCode

@RestControllerAdvice
class GlobalErrorHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException::class)
    protected fun handleBindBadRequestException(e: BindingResult): ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ErrorResponse(
                GlobalExceptionCode.BAD_REQUEST.status(),
                GlobalExceptionCode.BAD_REQUEST.code(),
                GlobalExceptionCode.BAD_REQUEST.message()
            ))
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException::class)
    protected fun handleConstraintViolationException(
        e: ConstraintViolationException
    ): ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ErrorResponse(
                GlobalExceptionCode.BAD_REQUEST.status(),
                GlobalExceptionCode.BAD_REQUEST.code(),
                GlobalExceptionCode.BAD_REQUEST.message()
            ))
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    protected fun handleMethodArgumentNotViolationException(
        e: BindingResult
    ): ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ErrorResponse(
                GlobalExceptionCode.BAD_REQUEST.status(),
                GlobalExceptionCode.BAD_REQUEST.code(),
                GlobalExceptionCode.BAD_REQUEST.message()
            ))
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException::class)
    protected fun handleHttpMessageNotReadableException(
        e: HttpMessageNotReadableException
    ): ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ErrorResponse(
                GlobalExceptionCode.BAD_REQUEST.status(),
                GlobalExceptionCode.BAD_REQUEST.code(),
                GlobalExceptionCode.BAD_REQUEST.message()
            ))
    }
}