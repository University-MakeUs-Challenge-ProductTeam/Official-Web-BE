package umc.product.web.domain.umc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.product.web.domain.umc.dto.UMCResponseDTO;
import umc.product.web.domain.umc.service.UMCQueryService;
import umc.product.web.global.common.BaseResponse;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "UMC 기본 정보 API")
public class UMCController {

    private final UMCQueryService umcQueryService;

    @GetMapping("/schools")
    @Operation(summary = "참여 학교 리스트 조회", description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public BaseResponse<UMCResponseDTO.GetParticipateSchoolList> getParticipateSchoolList() {
        return BaseResponse.onSuccess(umcQueryService.getParticipateSchoolList());
    }
}
