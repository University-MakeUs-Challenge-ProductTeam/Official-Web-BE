package umc.product.web.domain.umc.converter;

import umc.product.web.domain.project.entity.ParticipateSchool;
import umc.product.web.domain.umc.dto.UMCResponseDTO;

import java.util.List;

public class UMCConverter {

    public static UMCResponseDTO.ParticipateSchoolDTO toParticipateSchoolDTO(ParticipateSchool participateSchool) {
        return UMCResponseDTO.ParticipateSchoolDTO.builder()
                .participateSchoolId(participateSchool.getId())
                .schoolName(participateSchool.getName())
                .build();
    }

    public static UMCResponseDTO.GetParticipateSchoolList toGetParticipateSchoolListDTO(List<ParticipateSchool> participateSchoolList) {
        List<UMCResponseDTO.ParticipateSchoolDTO> list = participateSchoolList.stream()
                .map(UMCConverter::toParticipateSchoolDTO)
                .toList();

        return UMCResponseDTO.GetParticipateSchoolList.builder()
                .participateSchoolList(list)
                .build();
    }
}
