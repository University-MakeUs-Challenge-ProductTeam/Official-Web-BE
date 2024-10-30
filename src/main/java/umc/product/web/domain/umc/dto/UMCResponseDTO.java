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
    public static class ParticipateSchoolDTO {
        private Long participateSchoolId;
        private String schoolName;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetParticipateSchoolList {
        private List<ParticipateSchoolDTO> participateSchoolList;
    }
}
