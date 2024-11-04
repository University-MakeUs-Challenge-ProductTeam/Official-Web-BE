package umc.product.web.domain.centralStaff.controller;

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
import umc.product.web.domain.centralStaff.dto.CentralStaffResponseDTO;
import umc.product.web.domain.centralStaff.service.CentralStaffQueryService;
import umc.product.web.global.common.BaseResponse;
import umc.product.web.global.validation.annotation.CheckCursorValidation;
import umc.product.web.global.validation.annotation.CheckTakeValidation;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/central-staffs")
@Tag(name = "중앙 운영진 API")
public class CentralStaffController {

    private final CentralStaffQueryService centralStaffQueryService;

    @GetMapping("")
    @Operation(summary = "중앙 운영진 리스트 조회", description = "커서 초기값은 0 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다."),
            @ApiResponse(responseCode = "COMMON_005", description = "커서 값이 유효하지 않습니다.  초기값은 0 입니다."),
            @ApiResponse(responseCode = "COMMON_006", description = "take 값이 유효하지 않습니다.")
    })
    public BaseResponse<CentralStaffResponseDTO.CentralStaffListDTO> getCentralStaffList(
            @RequestParam(name = "generation", required = false) Integer generation,
            @CheckCursorValidation @RequestParam(name = "cursor") Long cursor,
            @CheckTakeValidation @RequestParam(name = "take") Integer take
    ) {
        return BaseResponse.onSuccess(centralStaffQueryService.getCentralStaffList(generation, cursor, take));
    }

    @GetMapping("/generations")
    @Operation(summary = "중앙 운영진 기수 조회", description = "중앙 운영진 기수 리스트를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public BaseResponse<CentralStaffResponseDTO.GetGenerationListDTO> getGenerationList() {
        return BaseResponse.onSuccess(centralStaffQueryService.getGenerationList());
    }
}
