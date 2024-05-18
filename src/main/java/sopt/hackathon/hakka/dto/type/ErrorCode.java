package sopt.hackathon.hakka.dto.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    //400
    BAD_REQUEST(400, HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    MISSING_REQUEST_HEADER(400, HttpStatus.BAD_REQUEST, "필수 헤더가 누락되었습니다."),
    // 404 Not Found
    NOT_FOUND_END_POINT(400, HttpStatus.NOT_FOUND, "존재하지 않는 API입니다."),
    NOT_FOUND_MEMBER(400, HttpStatus.NOT_FOUND, "존재하지 않는 사용자입니다.");


    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;
}
