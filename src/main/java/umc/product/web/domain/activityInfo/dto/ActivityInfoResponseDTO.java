package umc.product.web.domain.activityInfo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class ActivityInfoResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ActivityInfoDetailDTO {
        private Long activityInfoId;
        private Integer generation;
        private LocalDate activityStartDate;
        private LocalDate activityEndDate;
        private LocalDate unionOTDate;
        private Integer clubFee;
        private Integer projectFee;
        private Integer projectPaybackFee;
    }
}
