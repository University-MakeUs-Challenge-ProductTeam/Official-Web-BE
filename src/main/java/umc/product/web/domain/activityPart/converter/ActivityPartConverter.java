package umc.product.web.domain.activityPart.converter;

import umc.product.web.domain.activityPart.dto.ActivityPartResponseDTO;
import umc.product.web.domain.activityPart.entity.ActivityPart;
import umc.product.web.domain.activityPart.entity.ActivityPartCurriculum;

import java.util.List;

public class ActivityPartConverter {

    public static ActivityPartResponseDTO.ActivityPartCurriculumDTO toActivityPartCurriculumDTO(ActivityPartCurriculum activityPartCurriculum) {
        return ActivityPartResponseDTO.ActivityPartCurriculumDTO.builder()
                .curriculumId(activityPartCurriculum.getId())
                .week(activityPartCurriculum.getWeek())
                .topic(activityPartCurriculum.getTopic())
                .build();
    }

    public static ActivityPartResponseDTO.GetActivityPartCurriculumList toGetPActivityPartCurriculumList(ActivityPart activityPart, List<ActivityPartCurriculum> activityPartCurriculumList) {
        List<ActivityPartResponseDTO.ActivityPartCurriculumDTO> list = activityPartCurriculumList.stream()
                .map(ActivityPartConverter::toActivityPartCurriculumDTO)
                .toList();

        return ActivityPartResponseDTO.GetActivityPartCurriculumList.builder()
                .partId(activityPart.getId())
                .partName(activityPart.getPartName())
                .requireSkill(activityPart.getRequireSkill())
                .activityPartCurriculumList(list)
                .build();
    }
}
