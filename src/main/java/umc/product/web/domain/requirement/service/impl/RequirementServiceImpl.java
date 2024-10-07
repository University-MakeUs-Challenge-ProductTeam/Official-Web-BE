package umc.product.web.domain.requirement.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.product.web.domain.requirement.converter.RequirementConverter;
import umc.product.web.domain.requirement.dto.RequirementResponseDTO;
import umc.product.web.domain.requirement.entity.RequirementPart;
import umc.product.web.domain.requirement.entity.RequirementSchool;
import umc.product.web.domain.requirement.entity.Staff;
import umc.product.web.domain.requirement.repository.RequirementPartRepository;
import umc.product.web.domain.requirement.repository.RequirementSchoolRepository;
import umc.product.web.domain.requirement.repository.StaffRepository;
import umc.product.web.domain.requirement.service.RequirementQueryService;
import umc.product.web.global.error.code.handler.RequirementHandler;
import umc.product.web.global.error.code.status.ErrorStatus;

import java.lang.reflect.Parameter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequirementServiceImpl implements RequirementQueryService {

    private final RequirementSchoolRepository requirementSchoolRepository;
    private final StaffRepository staffRepository;
    private final RequirementPartRepository requirementPartRepository;


    @Override
    public RequirementResponseDTO.RequirementInfoDTO getRequirementInfo(String name) {

        RequirementSchool requirementSchool = requirementSchoolRepository.findByName(name).orElseThrow(()-> new RequirementHandler(ErrorStatus.REQUIREMENT_NOT_FOUND));

        List<RequirementPart> requirementPartList = requirementPartRepository.findByRequirementSchool(requirementSchool);

        List<Staff> staffList = staffRepository.findByRequirementSchool(requirementSchool);

        List<RequirementResponseDTO.StaffDTO> staffDTOList = staffList.stream().map(RequirementConverter::toStaffDTO).toList();

        List<RequirementResponseDTO.RequirementPartDTO> requirementPartDTOList = requirementPartList.stream().map(RequirementConverter::toRequirementPartDTO).toList();

        RequirementResponseDTO.RecruitmentScheduleDTO recruitmentScheduleDTO = RequirementConverter.toRecruitmentScheduleDTO(requirementSchool);

        return RequirementConverter.toRequirementInfoDTO(requirementSchool.getName(), requirementPartDTOList, recruitmentScheduleDTO, staffDTOList);
    }
}
