package sopt.hackathon.hakka.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sopt.hackathon.hakka.dto.common.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // 커스텀 예외
    @ExceptionHandler(value = {CustomException.class})
    public ResponseEntity<ApiResponse<Object>> handleCustomException(CustomException e) {
        return ResponseEntity
                .status(e.getErrorCode().getHttpStatus())
                .body(ApiResponse.fail(e.getErrorCode()));
    }
}