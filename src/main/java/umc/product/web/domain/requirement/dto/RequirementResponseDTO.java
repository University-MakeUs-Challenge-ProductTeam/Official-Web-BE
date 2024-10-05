package umc.product.web.domain.requirement.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.product.web.domain.requirement.entity.RequirementPart;
import umc.product.web.domain.requirement.entity.RequirementSchool;
import umc.product.web.domain.requirement.entity.enums.Part;

import java.time.LocalDate;
import java.util.List;

public class RequirementResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequirementInfoDTO {
        private String name;
        private RecruitmentScheduleDTO recruitmentScheduleDTO;
        private List<RequirementPartDTO> requirementPartDTOList;
        private List<StaffDTO> staffDTOList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecruitmentScheduleDTO {
        private LocalDate submissionStart;
        private LocalDate submissionEnd;
        private LocalDate firstResultDate;
        private LocalDate finalResultDate;
        private LocalDate schoolOTDate;
        private LocalDate interviewStartDate;
        private LocalDate interviewEndDate;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequirementPartDTO {
        private Part part;
        private String requireSkill;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StaffDTO {
        private String name;
        private String nickname;
        private String role;
    }

}
