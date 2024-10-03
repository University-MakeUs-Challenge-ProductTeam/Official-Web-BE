package umc.product.web.global.error.code.handler;

import umc.product.web.global.error.GeneralException;
import umc.product.web.global.error.code.BaseErrorCode;

public class SponsorHandler extends GeneralException {
    public SponsorHandler(BaseErrorCode code) {
        super(code);
    }
}
