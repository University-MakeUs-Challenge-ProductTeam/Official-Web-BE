package umc.product.web.domain.umc.converter;

import umc.product.web.domain.requirement.entity.RequirementSchool;
import umc.product.web.domain.umc.dto.UMCResponseDTO;

import java.util.List;

public class UMCConverter {

    public static UMCResponseDTO.CurrentParticipatingSchool toCurrentParticipatingSchool(RequirementSchool requirementSchool) {
        return UMCResponseDTO.CurrentParticipatingSchool.builder()
                .participateSchoolId(requirementSchool.getId())
                .schoolName(requirementSchool.getName())
                .build();
    }

    public static UMCResponseDTO.GetCurrentParticipatingSchoolList toGetCurrentParticipatingSchoolList(List<RequirementSchool> requirementSchoolList) {
        List<UMCResponseDTO.CurrentParticipatingSchool> list = requirementSchoolList.stream()
                .map(UMCConverter::toCurrentParticipatingSchool)
                .toList();

        return UMCResponseDTO.GetCurrentParticipatingSchoolList.builder()
                .totalSchoolCount(requirementSchoolList.size())
                .participateSchoolList(list)
                .build();
    }
}
