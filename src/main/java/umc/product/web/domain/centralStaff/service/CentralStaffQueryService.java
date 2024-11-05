package umc.product.web.domain.centralStaff.service;

import umc.product.web.domain.centralStaff.dto.CentralStaffResponseDTO;

public interface CentralStaffQueryService {

    CentralStaffResponseDTO.CentralStaffListDTO getCentralStaffList(Integer generation, Long cursor, Integer take);

    CentralStaffResponseDTO.GetGenerationListDTO getGenerationList();
}
