package sopt.hackathon.hakka.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import sopt.hackathon.hakka.dto.type.ErrorCode;

@Getter
@RequiredArgsConstructor
public class CustomException extends RuntimeException{
    private final ErrorCode errorCode;

    public String getMessage() {
        return errorCode.getMessage();
    }
}
