package umc.product.web.domain.project.service;

import umc.product.web.domain.project.dto.ProjectResponseDTO;

public interface ProjectQueryService {

    ProjectResponseDTO.ReleasedProjectListDTO getReleasedProjects(Long cursor, Integer take);
}
