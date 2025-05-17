package umc.product.web.domain.requirement.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.product.web.domain.requirement.converter.RequirementConverter;
import umc.product.web.domain.requirement.dto.RequirementResponseDTO;
import umc.product.web.domain.requirement.entity.RequirementPart;
import umc.product.web.domain.requirement.entity.RequirementSchool;
import umc.product.web.domain.requirement.entity.SchoolStaff;
import umc.product.web.domain.requirement.repository.RequirementPartRepository;
import umc.product.web.domain.requirement.repository.RequirementSchoolRepository;
import umc.product.web.domain.requirement.repository.SchoolStaffRepository;
import umc.product.web.domain.requirement.service.RequirementQueryService;
import umc.product.web.global.error.code.handler.RequirementHandler;
import umc.product.web.global.error.code.status.ErrorStatus;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequirementServiceImpl implements RequirementQueryService {

    private final RequirementSchoolRepository requirementSchoolRepository;
    private final SchoolStaffRepository schoolStaffRepository;
    private final RequirementPartRepository requirementPartRepository;


    @Override
    public RequirementResponseDTO.RequirementInfoDTO getRequirementInfo(String name) {

        RequirementSchool requirementSchool = requirementSchoolRepository.findByNameAndDeletedAtIsNull(name).orElseThrow(()-> new RequirementHandler(ErrorStatus.REQUIREMENT_NOT_FOUND));

        List<RequirementPart> requirementPartList = requirementPartRepository.findByRequirementSchool(requirementSchool);

        List<SchoolStaff> staffList = schoolStaffRepository.findByRequirementSchool(requirementSchool);

        List<RequirementResponseDTO.StaffDTO> staffDTOList = staffList.stream().map(RequirementConverter::toStaffDTO).toList();

        List<RequirementResponseDTO.RequirementPartDTO> requirementPartDTOList = requirementPartList.stream().map(RequirementConverter::toRequirementPartDTO).toList();

        RequirementResponseDTO.RecruitmentScheduleDTO recruitmentScheduleDTO = RequirementConverter.toRecruitmentScheduleDTO(requirementSchool);

        return RequirementConverter.toRequirementInfoDTO(requirementSchool.getName(), requirementSchool.getInstagramAccount(), requirementPartDTOList, recruitmentScheduleDTO, staffDTOList);
    }
}
