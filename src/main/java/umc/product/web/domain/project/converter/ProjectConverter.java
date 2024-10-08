package umc.product.web.domain.project.converter;

import org.springframework.data.domain.Slice;
import umc.product.web.domain.project.dto.ProjectResponseDTO;
import umc.product.web.domain.project.entity.*;
import umc.product.web.domain.project.entity.enums.PlatformName;

import java.util.List;

public class ProjectConverter {

    public static ProjectResponseDTO.ReleasedProjectDTO toReleasedProjectDTO(Project project) {

        List<PlatformName> platformNameList = project.getProjectPlatforms().stream()
                .map(ProjectPlatform::getPlatform)
                .map(Platform::getPlatformName)
                .toList();

        return ProjectResponseDTO.ReleasedProjectDTO.builder()
                .projectId(project.getId())
                .projectName(project.getName())
                .description(project.getDescription())
                .imageUrl(project.getImageUrl() != null && !project.getImageUrl().isEmpty() ? project.getImageUrl() : null)
                .platFormNameList(platformNameList)
                .build();
    }

    public static ProjectResponseDTO.ReleasedProjectListDTO toReleasedProjectListDTO(Slice<Project> projectSlice) {

        List<ProjectResponseDTO.ReleasedProjectDTO> releasedProjectDTOList = projectSlice.stream()
                .map(ProjectConverter::toReleasedProjectDTO)
                .toList();

        Long nextCursor = projectSlice.hasNext() && !projectSlice.getContent().isEmpty()
                ? projectSlice.getContent().get(projectSlice.getNumberOfElements() - 1).getId()
                : null;

        return ProjectResponseDTO.ReleasedProjectListDTO.builder()
                .releasedProjectDTOList(releasedProjectDTOList)
                .hasNext(projectSlice.hasNext())
                .nextCursor(nextCursor)
                .build();
    }

    public static ProjectResponseDTO.UMCProjectDTO toUMCProjectDTO(Project project) {

        List<PlatformName> platformNameList = project.getProjectPlatforms().stream()
                .map(ProjectPlatform::getPlatform)
                .map(Platform::getPlatformName)
                .toList();

        return ProjectResponseDTO.UMCProjectDTO.builder()
                .projectId(project.getId())
                .projectName(project.getName())
                .description(project.getDescription())
                .imageUrl(project.getImageUrl() != null && !project.getImageUrl().isEmpty() ? project.getImageUrl() : null)
                .platFormNameList(platformNameList)
                .build();
    }

    public static ProjectResponseDTO.UMCProjectListDTO toUMCProjectListDTO(Slice<Project> projectSlice) {

        List<ProjectResponseDTO.UMCProjectDTO> umcProjectDTOList = projectSlice.stream()
                .map(ProjectConverter::toUMCProjectDTO)
                .toList();

        Long nextCursor = projectSlice.hasNext() && !projectSlice.getContent().isEmpty()
                ? projectSlice.getContent().get(projectSlice.getNumberOfElements() - 1).getId()
                : null;

        return ProjectResponseDTO.UMCProjectListDTO.builder()
                .umcProjectDTOList(umcProjectDTOList)
                .hasNext(projectSlice.hasNext())
                .nextCursor(nextCursor)
                .build();
    }

    public static ProjectResponseDTO.ProjectDetailDTO toProjectDetailDTO(Project project, List<ProjectParticipateSchool> projectParticipateSchoolList, List<ProjectMember> projectMemberList) {

        List<PlatformName> platformNameList = project.getProjectPlatforms().stream()
                .map(ProjectPlatform::getPlatform)
                .map(Platform::getPlatformName)
                .toList();

        List<ProjectResponseDTO.ProjectMemberDTO> projectMemberDTOList = projectMemberList.stream()
                .map(ProjectConverter::toProjectMemberDTO)
                .toList();

        List<String> participateSchoolList = projectParticipateSchoolList.stream()
                .map(school -> {return school.getParticipateSchool().getName();})
                .toList();

        return ProjectResponseDTO.ProjectDetailDTO.builder()
                .projectId(project.getId())
                .projectName(project.getName())
                .imageUrl(project.getImageUrl() != null && !project.getImageUrl().isEmpty() ? project.getImageUrl() : null)
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
}
