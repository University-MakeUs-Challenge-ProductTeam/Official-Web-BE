package umc.product.web.domain.activityPart.service;

import umc.product.web.domain.activityPart.dto.ActivityPartResponseDTO;
import umc.product.web.domain.activityPart.entity.enums.Part;

public interface ActivityPartQueryService {

    ActivityPartResponseDTO.GetActivityPartCurriculumList getActivityPartCurriculumsList(Part part);

    ActivityPartResponseDTO.GetActivityPartList getActivityPartList();
}
