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
import umc.product.web.global.validation.annotation.CheckPageValidation;
import umc.product.web.global.validation.annotation.CheckSizeValidation;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/central-staff")
@Tag(name = "중앙 운영진 API")
public class CentralStaffController {

    private final CentralStaffQueryService centralStaffQueryService;

    @GetMapping("")
    @Operation(summary = "중앙 운영진 리스트 조회", description = "page 초기값은 0 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다."),
            @ApiResponse(responseCode = "PAGE_003", description = "page 값이 유효하지 않습니다."),
            @ApiResponse(responseCode = "PAGE_004", description = "size 값이 유효하지 않습니다.")})
    public BaseResponse<CentralStaffResponseDTO.CentralStaffListDTO> getCentralStaffList(
            @RequestParam(name = "generation", required = false) Integer generation,
            @CheckPageValidation @RequestParam(name = "page") int page,
            @CheckSizeValidation @RequestParam(name = "size") int size) {
        return BaseResponse.onSuccess(centralStaffQueryService.getCentralStaffList(generation, page, size));
    }
}
