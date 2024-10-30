package umc.product.web.global.error.code.handler;

import umc.product.web.global.error.GeneralException;
import umc.product.web.global.error.code.BaseErrorCode;

public class ActivityPartHandler extends GeneralException {
    public ActivityPartHandler(BaseErrorCode code) {
        super(code);
    }
}
