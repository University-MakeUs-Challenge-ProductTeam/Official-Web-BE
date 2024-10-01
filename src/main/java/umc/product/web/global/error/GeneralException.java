package umc.product.web.global.error;


import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.product.web.global.error.code.BaseErrorCode;
import umc.product.web.global.error.code.ErrorReasonDTO;

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
