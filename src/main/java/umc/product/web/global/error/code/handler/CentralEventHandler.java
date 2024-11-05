package umc.product.web.global.error.code.handler;

import umc.product.web.global.error.GeneralException;
import umc.product.web.global.error.code.BaseErrorCode;

public class CentralEventHandler extends GeneralException {
    public CentralEventHandler(BaseErrorCode code) {
        super(code);
    }
}
