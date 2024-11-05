package umc.product.web.domain.requirement.converter;

import umc.product.web.domain.requirement.dto.RequirementResponseDTO;
import umc.product.web.domain.requirement.entity.RequirementPart;
import umc.product.web.domain.requirement.entity.RequirementSchool;
import umc.product.web.domain.requirement.entity.SchoolStaff;

import java.util.List;

public class RequirementConverter {

    public static RequirementResponseDTO.RequirementInfoDTO toRequirementInfoDTO(
            String schoolName,
            String instagramAccount,
            List<RequirementResponseDTO.RequirementPartDTO> requirementPartDTOList,
            RequirementResponseDTO.RecruitmentScheduleDTO recruitmentScheduleDTO,
            List<RequirementResponseDTO.StaffDTO> staffDTOList
    ) {
        return RequirementResponseDTO.RequirementInfoDTO.builder()
                .name(schoolName)
                .instagramAccount(instagramAccount)
                .requirementPartDTOList(requirementPartDTOList)
                .recruitmentScheduleDTO(recruitmentScheduleDTO)
                .staffDTOList(staffDTOList)
                .build();
    }

    public static RequirementResponseDTO.RecruitmentScheduleDTO toRecruitmentScheduleDTO (RequirementSchool requirementSchool) {
        return RequirementResponseDTO.RecruitmentScheduleDTO.builder()
                .firstResultDate(requirementSchool.getFirstResultDate())
                .finalResultDate(requirementSchool.getFinalResultDate())
                .interviewStartDate(requirementSchool.getInterviewStartDate())
                .interviewEndDate(requirementSchool.getInterviewEndDate())
                .schoolOTDate(requirementSchool.getSchoolOtDate())
                .submissionEnd(requirementSchool.getSubmissionEnd())
                .submissionStart(requirementSchool.getSubmissionStart())
                .build();
    }

    public static RequirementResponseDTO.StaffDTO toStaffDTO(SchoolStaff schoolStaff) {
        return RequirementResponseDTO.StaffDTO.builder()
                .name(schoolStaff.getName())
                .role(schoolStaff.getRole())
                .nickname(schoolStaff.getNickname())
                .build();
    }

    public static RequirementResponseDTO.RequirementPartDTO toRequirementPartDTO(RequirementPart requirementPart) {
        return RequirementResponseDTO.RequirementPartDTO.builder()
                .part(requirementPart.getPart())
                .requireSkill(requirementPart.getRequireSkill())
                .build();
    }
}
