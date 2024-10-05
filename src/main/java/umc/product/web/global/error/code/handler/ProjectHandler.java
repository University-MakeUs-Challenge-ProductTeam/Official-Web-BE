package umc.product.web.global.error.code.handler;

import umc.product.web.global.error.GeneralException;
import umc.product.web.global.error.code.BaseErrorCode;

public class ProjectHandler extends GeneralException {
    public ProjectHandler(BaseErrorCode code) {
        super(code);
    }
}
