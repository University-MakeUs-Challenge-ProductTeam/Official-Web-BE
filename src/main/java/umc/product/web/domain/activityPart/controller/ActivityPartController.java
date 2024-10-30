package umc.product.web.domain.activityPart.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.product.web.domain.activityPart.dto.ActivityPartResponseDTO;
import umc.product.web.domain.activityPart.entity.enums.Part;
import umc.product.web.domain.activityPart.service.ActivityPartQueryService;
import umc.product.web.global.common.BaseResponse;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/activity-parts")
@Tag(name = "활동 파트 API")
public class ActivityPartController {

    private final ActivityPartQueryService activityPartQueryService;

    @GetMapping("/curriculum")
    public BaseResponse<ActivityPartResponseDTO.GetActivityPartCurriculumList> getActivityPartCurriculumsList(
            @RequestParam(name = "part") Part part) {
        return BaseResponse.onSuccess(activityPartQueryService.getActivityPartCurriculumsList(part));
    }
}
