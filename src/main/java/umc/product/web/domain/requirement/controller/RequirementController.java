package umc.product.web.domain.requirement.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.product.web.domain.requirement.dto.RequirementResponseDTO;
import umc.product.web.domain.requirement.service.RequirementQueryService;
import umc.product.web.global.error.code.ErrorReasonDTO;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/requirements")
@Tag(name = "모집 일정 API")
public class RequirementController {

    public final RequirementQueryService requirementQueryService;

    @Operation(summary = "모집 일정, 모집 파트, 필수 역량, 운영진 조회 API", description = "학교에 맞추어서 모집 일정, 모집 파트, 필수 역량, 운영진 정보를 조회 합니다. _by 제이미_")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "COMMON200",
                    description = "OK, 성공"
            ),
            @ApiResponse(
                    responseCode = "REQUIREMENT001",
                    description = "REQUIREMENT가 존재하지 않습니다.",
                    content = @Content(schema = @Schema(implementation = ErrorReasonDTO.class))
            ),
    })
    @GetMapping("")
    public RequirementResponseDTO.RequirementInfoDTO getRequirementInfo(@RequestParam("schoolName") String schoolName) {
        return requirementQueryService.getRequirementInfo(schoolName);
    }

}
