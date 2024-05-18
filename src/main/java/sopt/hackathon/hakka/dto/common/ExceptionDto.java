package sopt.hackathon.hakka.dto.common;

import org.antlr.v4.runtime.misc.NotNull;
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
