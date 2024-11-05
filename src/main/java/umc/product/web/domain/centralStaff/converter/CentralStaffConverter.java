package umc.product.web.domain.centralStaff.converter;

import org.springframework.data.domain.Page;
import umc.product.web.domain.centralStaff.dto.CentralStaffResponseDTO;
import umc.product.web.domain.centralStaff.entity.CentralStaff;
import umc.product.web.domain.centralStaff.entity.ProfileLink;

import java.util.List;

public class CentralStaffConverter {

    public static CentralStaffResponseDTO.ProfileLinkDTO toProfileLinkDTO(ProfileLink profileLink) {
        return CentralStaffResponseDTO.ProfileLinkDTO.builder()
                .profileLinkId(profileLink.getId())
                .linkType(profileLink.getLinkType())
                .linkUrl(profileLink.getLinkUrl())
                .build();
    }

    public static CentralStaffResponseDTO.CentralStaffDTO toCentralStaffDTO(CentralStaff centralStaff) {
        List<CentralStaffResponseDTO.ProfileLinkDTO> list = centralStaff.getProfileLinkList().stream()
                .map(CentralStaffConverter::toProfileLinkDTO)
                .toList();

        return CentralStaffResponseDTO.CentralStaffDTO.builder()
                .centralStaffId(centralStaff.getId())
                .nickname(centralStaff.getNickname())
                .role(centralStaff.getRole())
                .school(centralStaff.getSchool())
                .introduction(centralStaff.getIntroduction())
                .profileImageUrl(centralStaff.getProfileImageUrl())
                .generation(centralStaff.getGeneration())
                .profileLinkList(list)
                .build();
    }

    public static CentralStaffResponseDTO.CentralStaffListDTO toCentralStaffListDTO(Page<CentralStaff> page) {
        List<CentralStaffResponseDTO.CentralStaffDTO> list = page.stream()
                .map(CentralStaffConverter::toCentralStaffDTO)
                .toList();

        return CentralStaffResponseDTO.CentralStaffListDTO.builder()
                .centralStaffList(list)
                .isFirst(page.isFirst())
                .hasNext(page.hasNext())
                .isFirst(page.isFirst())
                .hasNext(page.hasNext())
                .currentPage(page.getNumber())
                .pageSize(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .build();
    }

    public static CentralStaffResponseDTO.GetGenerationListDTO toGetGenerationListDTO(List<Integer> generationList ) {
        return CentralStaffResponseDTO.GetGenerationListDTO.builder()
                .generationList(generationList)
                .build();
    }
}
