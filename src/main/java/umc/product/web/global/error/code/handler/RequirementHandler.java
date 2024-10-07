package umc.product.web.global.error.code.handler;

import umc.product.web.global.error.GeneralException;
import umc.product.web.global.error.code.BaseErrorCode;

public class RequirementHandler extends GeneralException {
    public RequirementHandler(BaseErrorCode code) {
        super(code);
    }
}
