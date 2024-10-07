package umc.product.web.global.error.code.handler;

import umc.product.web.global.error.GeneralException;
import umc.product.web.global.error.code.BaseErrorCode;

public class ActivityHandler extends GeneralException {
    public ActivityHandler(BaseErrorCode code) {
        super(code);
    }
}
