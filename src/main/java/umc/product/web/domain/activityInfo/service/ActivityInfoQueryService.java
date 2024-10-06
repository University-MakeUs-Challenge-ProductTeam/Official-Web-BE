package umc.product.web.domain.activityInfo.service;

import umc.product.web.domain.activityInfo.dto.ActivityInfoResponseDTO;

public interface ActivityInfoQueryService {

    ActivityInfoResponseDTO.ActivityInfoDetailDTO getActivityInfoDetail();
}
