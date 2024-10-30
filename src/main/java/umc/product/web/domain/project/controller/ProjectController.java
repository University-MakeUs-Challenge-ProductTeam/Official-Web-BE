package umc.product.web.domain.project.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.product.web.domain.project.dto.ProjectResponseDTO;
import umc.product.web.domain.project.entity.enums.PlatformName;
import umc.product.web.domain.project.service.ProjectQueryService;
import umc.product.web.global.common.BaseResponse;
import umc.product.web.global.validation.annotation.CheckCursorValidation;
import umc.product.web.global.validation.annotation.CheckTakeValidation;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
@Tag(name = "프로젝트 API")
public class ProjectController {

    private final ProjectQueryService projectQueryService;

    @GetMapping("/released")
    @Operation(summary = "실출시된 프로젝트 조회", description = "커서 초기값은 0 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public BaseResponse<ProjectResponseDTO.ReleasedProjectListDTO> getReleasedProjects(
            @CheckCursorValidation @RequestParam(name = "cursor") Long cursor,
            @CheckTakeValidation @RequestParam(name = "take") Integer take
    ) {
        return BaseResponse.onSuccess(projectQueryService.getReleasedProjects(cursor, take));
    }

    @GetMapping("/umc")
    @Operation(summary = "UMC 프로젝트 조회", description = "커서 초기값은 0 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })

    public BaseResponse<ProjectResponseDTO.UMCProjectListDTO> getUMCProjects(
            @RequestParam(name = "generation", required = false) Integer generation,
            @RequestParam(name = "platformName", required = false) PlatformName platformName,
            @RequestParam(name = "searchTerm", required = false) String searchTerm,
            @CheckCursorValidation @RequestParam(name = "cursor") Long cursor,
            @CheckTakeValidation @RequestParam(name = "take") Integer take
    ) {
        return BaseResponse.onSuccess(projectQueryService.getUMCProjects(generation, platformName, searchTerm, cursor, take));
    }

    @GetMapping("/{projectId}")
    @Operation(summary = "프로젝트 상세 조회", description = "프로젝트의 상세 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public BaseResponse<ProjectResponseDTO.ProjectDetailDTO> getProjectDetail(
            @PathVariable Long projectId
    ) {
        return BaseResponse.onSuccess(projectQueryService.getProjectDetail(projectId));
    }

    @GetMapping("/generations")
    @Operation(summary = "프로젝트 기수 조회", description = "UMC 프로젝트의 기수 리스트를 조회합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public BaseResponse<ProjectResponseDTO.GetGenerationListDTO> getGenerationList() {
        return BaseResponse.onSuccess(projectQueryService.getGenerationList());
    }
}
