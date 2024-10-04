package umc.product.web.domain.project.converter;

import org.springframework.data.domain.Slice;
import umc.product.web.domain.project.dto.ProjectResponseDTO;
import umc.product.web.domain.project.entity.Platform;
import umc.product.web.domain.project.entity.Project;
import umc.product.web.domain.project.entity.ProjectPlatform;
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
}
