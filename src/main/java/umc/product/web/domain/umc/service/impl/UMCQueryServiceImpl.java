package umc.product.web.domain.umc.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.product.web.domain.project.entity.ParticipateSchool;
import umc.product.web.domain.project.repository.ParticipateSchoolRepository;
import umc.product.web.domain.umc.converter.UMCConverter;
import umc.product.web.domain.umc.dto.UMCResponseDTO;
import umc.product.web.domain.umc.service.UMCQueryService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UMCQueryServiceImpl implements UMCQueryService {

    private final ParticipateSchoolRepository participateSchoolRepository;

    public UMCResponseDTO.GetParticipateSchoolList getParticipateSchoolList() {

        List<ParticipateSchool> participateSchoolList = participateSchoolRepository.findAll();

        return UMCConverter.toGetParticipateSchoolListDTO(participateSchoolList);
    }
}
