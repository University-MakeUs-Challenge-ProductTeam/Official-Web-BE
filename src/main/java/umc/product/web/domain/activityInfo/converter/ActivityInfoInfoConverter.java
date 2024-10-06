package umc.product.web.domain.activityInfo.converter;

import umc.product.web.domain.activityInfo.dto.ActivityInfoResponseDTO;
import umc.product.web.domain.activityInfo.entity.ActivityInfo;

public class ActivityInfoInfoConverter {

    public static ActivityInfoResponseDTO.ActivityInfoDetailDTO activityInfoDetailDTO(ActivityInfo activityInfo) {

        return ActivityInfoResponseDTO.ActivityInfoDetailDTO.builder()
                .activityInfoId(activityInfo.getId())
                .generation(activityInfo.getGeneration())
                .activityStartDate(activityInfo.getActivityStartDate())
                .activityEndDate(activityInfo.getActivityEndDate())
                .unionOTDate(activityInfo.getUnionOTDate())
                .clubFee(activityInfo.getClubFee())
                .projectFee(activityInfo.getProjectFee())
                .projectPaybackFee(activityInfo.getProjectPaybackFee())
                .build();
    }
}
