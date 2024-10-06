package umc.product.web.domain.activityInfo.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.product.web.domain.activityInfo.converter.ActivityInfoInfoConverter;
import umc.product.web.domain.activityInfo.dto.ActivityInfoResponseDTO;
import umc.product.web.domain.activityInfo.entity.ActivityInfo;
import umc.product.web.domain.activityInfo.repository.ActivityInfoRepository;
import umc.product.web.domain.activityInfo.service.ActivityInfoQueryService;
import umc.product.web.global.error.code.handler.ActivityHandler;

import static umc.product.web.global.error.code.status.ErrorStatus.ACTIVITY_INFO_NOT_FOUND;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ActivityInfoInfoQueryServiceImpl implements ActivityInfoQueryService {

    private final ActivityInfoRepository activityInfoRepository;

    @Override
    public ActivityInfoResponseDTO.ActivityInfoDetailDTO getActivityInfoDetail() {

        ActivityInfo activityInfo = activityInfoRepository.findTopByOrderByGenerationDesc()
                .orElseThrow(() -> new ActivityHandler(ACTIVITY_INFO_NOT_FOUND));

        return ActivityInfoInfoConverter.activityInfoDetailDTO(activityInfo);
    }
}
