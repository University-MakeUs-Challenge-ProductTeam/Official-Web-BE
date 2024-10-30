package umc.product.web.domain.activityPart.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.product.web.domain.activityPart.converter.ActivityPartConverter;
import umc.product.web.domain.activityPart.dto.ActivityPartResponseDTO;
import umc.product.web.domain.activityPart.entity.ActivityPart;
import umc.product.web.domain.activityPart.entity.ActivityPartCurriculum;
import umc.product.web.domain.activityPart.entity.enums.Part;
import umc.product.web.domain.activityPart.repository.ActivityPartCurriculumRepository;
import umc.product.web.domain.activityPart.repository.ActivityPartRepository;
import umc.product.web.domain.activityPart.service.ActivityPartQueryService;
import umc.product.web.global.error.code.handler.ActivityPartHandler;

import java.util.List;

import static umc.product.web.global.error.code.status.ErrorStatus.ACTIVITY_PART_NOT_FOUND;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ActivityPartQueryServiceImpl implements ActivityPartQueryService {

    private final ActivityPartRepository activityPartRepository;
    private final ActivityPartCurriculumRepository activityPartCurriculumRepository;

    @Override
    public ActivityPartResponseDTO.GetActivityPartCurriculumList getActivityPartCurriculumsList(Part partName) {

        ActivityPart activityPart = activityPartRepository.findByPartName(partName)
                .orElseThrow(() -> new ActivityPartHandler(ACTIVITY_PART_NOT_FOUND));
        List<ActivityPartCurriculum> activityPartCurriculumList =  activityPartCurriculumRepository.findAllByActivityPartId(activityPart.getId());

        return ActivityPartConverter.toGetPActivityPartCurriculumList(activityPart, activityPartCurriculumList);
    }

    @Override
    public ActivityPartResponseDTO.GetActivityPartList getActivityPartList() {

        List<ActivityPart> activityPartList = activityPartRepository.findAll();

        return ActivityPartConverter.toGetActivityPartList(activityPartList);
    }
}
