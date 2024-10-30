package umc.product.web.domain.activityPart.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
@RequestMapping("/api/parts")
@Tag(name = "파트 API")
public class ActivityPartController {

    private final ActivityPartQueryService activityPartQueryService;

    @GetMapping("/curriculum")
    @Operation(summary = "특정 활동 파트의 스터디 커리큘럼 조회", description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public BaseResponse<ActivityPartResponseDTO.GetActivityPartCurriculumList> getActivityPartCurriculumsList(
            @RequestParam(name = "part") Part part) {
        return BaseResponse.onSuccess(activityPartQueryService.getActivityPartCurriculumsList(part));
    }

    @GetMapping("/list")
    @Operation(summary = "활동 파트 전체 조회", description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public BaseResponse<ActivityPartResponseDTO.GetActivityPartList> getActivityPartList() {
        return BaseResponse.onSuccess(activityPartQueryService.getActivityPartList());
    }
}
