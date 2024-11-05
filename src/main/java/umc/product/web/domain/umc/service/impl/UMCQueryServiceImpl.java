package umc.product.web.domain.umc.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.product.web.domain.requirement.entity.RequirementSchool;
import umc.product.web.domain.requirement.repository.RequirementSchoolRepository;
import umc.product.web.domain.umc.converter.UMCConverter;
import umc.product.web.domain.umc.dto.UMCResponseDTO;
import umc.product.web.domain.umc.service.UMCQueryService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UMCQueryServiceImpl implements UMCQueryService {

    private final RequirementSchoolRepository requirementSchoolRepository;

    public UMCResponseDTO.GetCurrentParticipatingSchoolList getCurrentParticipatingSchoolList() {

        List<RequirementSchool> requirementSchoolList = requirementSchoolRepository.findAll();
        return UMCConverter.toGetCurrentParticipatingSchoolList(requirementSchoolList);
    }
}
