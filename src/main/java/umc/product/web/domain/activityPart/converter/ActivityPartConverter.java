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

    public static ActivityPartResponseDTO.ActivityPartDTO toActivityPartDTO(ActivityPart activityPart) {
        return ActivityPartResponseDTO.ActivityPartDTO.builder()
                .activityPartId(activityPart.getId())
                .partName(activityPart.getPartName())
                .requireSkill(activityPart.getRequireSkill())
                .build();
    }

    public static ActivityPartResponseDTO.GetActivityPartList toGetActivityPartList(List<ActivityPart> activityPartList) {
        List<ActivityPartResponseDTO.ActivityPartDTO> list = activityPartList.stream()
                .map(ActivityPartConverter::toActivityPartDTO)
                .toList();

        return ActivityPartResponseDTO.GetActivityPartList.builder()
                .activityPartList(list)
                .build();
    }
}
