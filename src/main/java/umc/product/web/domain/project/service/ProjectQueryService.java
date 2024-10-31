package umc.product.web.domain.project.service;

import umc.product.web.domain.project.dto.ProjectResponseDTO;
import umc.product.web.domain.project.entity.enums.PlatformName;

public interface ProjectQueryService {

    ProjectResponseDTO.ReleasedProjectListDTO getReleasedProjects(int page, int size);

    ProjectResponseDTO.UMCProjectListDTO getUMCProjects(Integer generation, PlatformName platformName, String searchTerm, int page, int size);

    ProjectResponseDTO.ProjectDetailDTO getProjectDetail(Long projectId);

    ProjectResponseDTO.GetGenerationListDTO getGenerationList();

    ProjectResponseDTO.GetPlatformListDTO getPlatformList();
}
