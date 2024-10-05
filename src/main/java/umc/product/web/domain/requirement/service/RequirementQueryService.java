package umc.product.web.domain.requirement.service;

import umc.product.web.domain.requirement.dto.RequirementResponseDTO;

public interface RequirementQueryService {
    RequirementResponseDTO.RequirementInfoDTO getRequirementInfo(String name);
}
