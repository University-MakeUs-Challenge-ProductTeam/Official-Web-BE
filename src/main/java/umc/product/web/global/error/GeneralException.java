package umc.product.web.global.error;


import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.product.web.global.error.common.BaseErrorCode;
import umc.product.web.global.error.common.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }
}
