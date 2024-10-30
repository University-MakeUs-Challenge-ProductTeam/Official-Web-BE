package umc.product.web.domain.activityPart.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.product.web.domain.activityPart.entity.enums.Part;

import java.util.List;

public class ActivityPartResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ActivityPartCurriculumDTO {
        private Long curriculumId;
        private Integer week;
        private String topic;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetActivityPartCurriculumList {
        private Long partId;
        private Part partName;
        private String requireSkill;
        private List<ActivityPartCurriculumDTO> activityPartCurriculumList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ActivityPartDTO {
        private Long activityPartId;
        private Part partName;
        private String requireSkill;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetActivityPartList {
        private List<ActivityPartDTO> activityPartList;
    }
}
