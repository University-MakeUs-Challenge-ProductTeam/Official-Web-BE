package umc.product.web.domain.umc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class UMCResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CurrentParticipatingSchool {
        private Long participateSchoolId;
        private String schoolName;
        private String logoImageUrl;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetCurrentParticipatingSchoolList {
        private Integer totalSchoolCount;
        private List<CurrentParticipatingSchool> participateSchoolList;
    }
}
