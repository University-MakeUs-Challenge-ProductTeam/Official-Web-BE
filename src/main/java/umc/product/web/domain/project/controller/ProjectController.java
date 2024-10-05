package umc.product.web.domain.project.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.product.web.domain.project.dto.ProjectResponseDTO;
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
    public BaseResponse<ProjectResponseDTO.ReleasedProjectListDTO> getReleasedProjects(
            @CheckCursorValidation @RequestParam(name = "cursor") Long cursor,
            @CheckTakeValidation @RequestParam(name = "take") Integer take
    ) {
        return BaseResponse.onSuccess(projectQueryService.getReleasedProjects(cursor, take));
    }

    @GetMapping("")
    public BaseResponse<ProjectResponseDTO.UMCProjectListDTO> getUMCProjects(
            @RequestParam(name = "generation", required = false) Integer generation,
            @RequestParam(name = "platformName", required = false) String platformName,
            @RequestParam(name = "searchTerm", required = false) String searchTerm,
            @CheckCursorValidation @RequestParam(name = "cursor") Long cursor,
            @CheckTakeValidation @RequestParam(name = "take") Integer take
    ) {
        return BaseResponse.onSuccess(projectQueryService.getUMCProjects(generation, platformName, searchTerm, cursor, take));
    }

    @GetMapping("/{projectId}")
    public BaseResponse<ProjectResponseDTO.ProjectDetailDTO> getProjectDetail(
            @PathVariable Long projectId
    ) {
        return BaseResponse.onSuccess(projectQueryService.getProjectDetail(projectId));
    }
}
