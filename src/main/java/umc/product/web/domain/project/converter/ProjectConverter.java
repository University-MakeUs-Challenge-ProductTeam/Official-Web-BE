package umc.product.web.domain.project.converter;

import org.springframework.data.domain.Page;
import umc.product.web.domain.project.dto.ProjectResponseDTO;
import umc.product.web.domain.project.entity.*;
import umc.product.web.domain.project.entity.enums.PlatformName;

import java.util.List;

public class ProjectConverter {

    public static ProjectResponseDTO.ReleasedProjectDTO toReleasedProjectDTO(Project project) {

        List<PlatformName> platformNameList = project.getProjectPlatforms().stream()
                .map(projectPlatform -> projectPlatform.getPlatform().getPlatformName())
                .toList();

        return ProjectResponseDTO.ReleasedProjectDTO.builder()
                .projectId(project.getId())
                .projectName(project.getName())
                .generation(project.getGeneration())
                .slogan(project.getSlogan())
                .projectLogoImageUrl(project.getProjectLogoImageUrl() != null && !project.getProjectLogoImageUrl().isEmpty() ? project.getProjectLogoImageUrl() : null)
                .platFormNameList(platformNameList)
                .build();
    }

    public static ProjectResponseDTO.ReleasedProjectListDTO toReleasedProjectListDTO(Page<Project> projectPage) {

        List<ProjectResponseDTO.ReleasedProjectDTO> releasedProjectDTOList = projectPage.stream()
                .map(ProjectConverter::toReleasedProjectDTO)
                .toList();

        return ProjectResponseDTO.ReleasedProjectListDTO.builder()
                .releasedProjectDTOList(releasedProjectDTOList)
                .isFirst(projectPage.isFirst())
                .hasNext(projectPage.hasNext())
                .currentPage(projectPage.getNumber())
                .pageSize(projectPage.getSize())
                .totalElements(projectPage.getTotalElements())
                .totalPages(projectPage.getTotalPages())
                .build();
    }

    public static ProjectResponseDTO.UMCProjectDTO toUMCProjectDTO(Project project) {

        List<PlatformName> platformNameList = project.getProjectPlatforms().stream()
                .map(projectPlatform -> projectPlatform.getPlatform().getPlatformName())
                .toList();

        return ProjectResponseDTO.UMCProjectDTO.builder()
                .projectId(project.getId())
                .projectName(project.getName())
                .generation(project.getGeneration())
                .slogan(project.getSlogan())
                .projectLandingImageUrl(project.getProjectLandingImageUrl() != null && !project.getProjectLandingImageUrl().isEmpty() ? project.getProjectLandingImageUrl() : null)
                .platFormNameList(platformNameList)
                .build();
    }

    public static ProjectResponseDTO.UMCProjectListDTO toUMCProjectListDTO(Page<Project> projectPage) {

        List<ProjectResponseDTO.UMCProjectDTO> umcProjectDTOList = projectPage.stream()
                .map(ProjectConverter::toUMCProjectDTO)
                .toList();

        return ProjectResponseDTO.UMCProjectListDTO.builder()
                .umcProjectList(umcProjectDTOList)
                .isFirst(projectPage.isFirst())
                .hasNext(projectPage.hasNext())
                .currentPage(projectPage.getNumber())
                .pageSize(projectPage.getSize())
                .totalElements(projectPage.getTotalElements())
                .totalPages(projectPage.getTotalPages())
                .build();
    }

    public static ProjectResponseDTO.ProjectDetailDTO toProjectDetailDTO(Project project, List<ProjectParticipateSchool> projectParticipateSchoolList, List<ProjectMember> projectMemberList) {

        List<PlatformName> platformNameList = project.getProjectPlatforms().stream()
                .map(projectPlatform -> projectPlatform.getPlatform().getPlatformName())
                .toList();

        List<ProjectResponseDTO.ProjectMemberDTO> projectMemberDTOList = projectMemberList.stream()
                .map(ProjectConverter::toProjectMemberDTO)
                .toList();

        List<String> participateSchoolList = projectParticipateSchoolList.stream()
                .map(school -> school.getParticipateSchool().getName())
                .toList();

        return ProjectResponseDTO.ProjectDetailDTO.builder()
                .projectId(project.getId())
                .projectName(project.getName())
                .projectLogoImageUrl(project.getProjectLogoImageUrl() != null && !project.getProjectLogoImageUrl().isEmpty() ? project.getProjectLogoImageUrl() : null)
                .slogan(project.getSlogan())
                .projectLandingImageUrl(project.getProjectLandingImageUrl() != null && !project.getProjectLandingImageUrl().isEmpty() ? project.getProjectLandingImageUrl() : null)
                .description(project.getDescription())
                .generation(project.getGeneration())
                .projectSchoolList(participateSchoolList)
                .startDate(project.getStartDate())
                .endDate(project.getEndDate())
                .platFormNameList(platformNameList)
                .isReleased(project.getIsReleased())
                .description(project.getDescription())
                .projectMemberDTOList(projectMemberDTOList)
                .build();
    }

    public static ProjectResponseDTO.ProjectMemberDTO toProjectMemberDTO(ProjectMember projectMember) {
        return ProjectResponseDTO.ProjectMemberDTO.builder()
                .projectMemberId(projectMember.getId())
                .nickname(projectMember.getNickname())
                .name(projectMember.getName())
                .part(projectMember.getPart())
                .build();
    }

    public static ProjectResponseDTO.GetGenerationListDTO toGetGenerationListDTO(List<Integer> generationList) {
        return ProjectResponseDTO.GetGenerationListDTO.builder()
                .generationList(generationList)
                .build();
    }

    public static ProjectResponseDTO.GetPlatformListDTO toGetPlatformListDTO(List<Platform> platformList) {
        List<PlatformName> list = platformList.stream()
                .map(Platform::getPlatformName)
                .toList();

        return ProjectResponseDTO.GetPlatformListDTO.builder()
                .platformList(list)
                .build();
    }

    public static ProjectResponseDTO.ProjectDTO toProjectDTO(Project project) {
        return ProjectResponseDTO.ProjectDTO.builder()
                .projectId(project.getId())
                .projectName(project.getName())
                .slogan(project.getSlogan())
                .generation(project.getGeneration())
                .projectLandingImageUrl(project.getProjectLandingImageUrl())
                .build();
    }

    public static ProjectResponseDTO.GetTotalProjectListDTO toGetTotalProjectListDTO(List<Project> projectList) {
        List<ProjectResponseDTO.ProjectDTO> list = projectList.stream()
                .map(ProjectConverter::toProjectDTO)
                .toList();

        return ProjectResponseDTO.GetTotalProjectListDTO.builder()
                .projectList(list)
                .build();
    }
}
