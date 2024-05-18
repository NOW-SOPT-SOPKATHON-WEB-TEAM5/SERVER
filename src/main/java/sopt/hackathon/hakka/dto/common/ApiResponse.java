package sopt.hackathon.hakka.dto.common;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import sopt.hackathon.hakka.dto.type.ErrorCode;

public record ApiResponse<T>(
        @JsonIgnore
        HttpStatus httpStatus,
        @NotNull boolean success,
        @Nullable T data,
        @Nullable ExceptionDto error
) {

    public static <T> ApiResponse<T> ok(@Nullable final T data) {
        return new ApiResponse<>(HttpStatus.OK, true, data, null);
    }

    public static <T> ApiResponse<T> created(@Nullable final T data) {
        return new ApiResponse<>(HttpStatus.CREATED, true, data, null);
    }

    public static <T> ApiResponse<T> fail(final ErrorCode c) {
        return new ApiResponse<>(c.getHttpStatus(), false, null, ExceptionDto.of(c));
    }
}