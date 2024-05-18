package sopt.hackathon.hakka.dto.common;

import org.jetbrains.annotations.NotNull;
import sopt.hackathon.hakka.dto.type.ErrorCode;

public record ExceptionDto (
        @NotNull Integer code,
        @NotNull String message
) {

    public static ExceptionDto of(ErrorCode errorCode) {
        return new ExceptionDto(
                errorCode.getCode(),
                errorCode.getMessage()
        );
    }
}
