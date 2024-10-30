package umc.product.web.domain.project.service;

import umc.product.web.domain.project.dto.ProjectResponseDTO;
import umc.product.web.domain.project.entity.enums.PlatformName;

public interface ProjectQueryService {

    ProjectResponseDTO.ReleasedProjectListDTO getReleasedProjects(Long cursor, Integer take);

    ProjectResponseDTO.UMCProjectListDTO getUMCProjects(Integer generation, PlatformName platformName, String searchTerm, Long cursor, Integer take);

    ProjectResponseDTO.ProjectDetailDTO getProjectDetail(Long projectId);

    ProjectResponseDTO.GetGenerationListDTO getGenerationList();

    ProjectResponseDTO.GetPlatformListDTO getPlatformList();
}
