package umc.product.web.domain.activityInfo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.product.web.domain.activityInfo.dto.ActivityInfoResponseDTO;
import umc.product.web.domain.activityInfo.service.ActivityInfoQueryService;
import umc.product.web.global.common.BaseResponse;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/activities")
@Tag(name = "활동 API")
public class ActivityInfoController {

    private final ActivityInfoQueryService activityInfoQueryService;

    @GetMapping("")
    public BaseResponse<ActivityInfoResponseDTO.ActivityInfoDetailDTO> getActivityInfoDetail() {
        return BaseResponse.onSuccess(activityInfoQueryService.getActivityInfoDetail());
    }
}
