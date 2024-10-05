package umc.product.web.global.error.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.product.web.global.error.code.BaseErrorCode;
import umc.product.web.global.error.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    // 기본 에러
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // 공통 에러
    PAGE_UNDER_ZERO(HttpStatus.BAD_REQUEST, "COMMON_001", "페이지는 0이상이어야 합니다."),
    MULTIPLE_FIELD_VALIDATION_ERROR(HttpStatus.BAD_REQUEST, "COMMON_002", "입력된 정보에 오류가 있습니다. 필드별 오류 메시지를 참조하세요."),
    NO_MATCHING_ERROR_STATUS(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON_003", "서버 에러. 일치하는 errorStatus를 찾을 수 없습니다."),
    REQUEST_BODY_INVALID(HttpStatus.BAD_REQUEST, "COMMON_004", "요청 본문을 읽을 수 없습니다. 빈 문자열 또는 null이 있는지 확인해주세요."),
    NOT_VALID_CURSOR(HttpStatus.BAD_REQUEST, "COMMON_005", "커서 값이 유효하지 않습니다."),
    NOT_VALID_TAKE(HttpStatus.BAD_REQUEST, "COMMON_006", "take 값이 유효하지 않습니다."),

    // Sponsor 에러
    SPONSOR_NOT_FOUND(HttpStatus.NOT_FOUND, "SPONSOR001", "SPONSOR가 존재하지 않습니다."),

    // Project 에러
    PROJECT_NOT_FOUND(HttpStatus.NOT_FOUND, "PROJECT001", "PROJECT가 존재하지 않습니다."),

    // REQUIREMENT 에러
    REQUIREMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "REQUIREMENT001", "REQUIREMENT가 존재하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder().message(message).code(code).isSuccess(false).build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
