package umc.product.web.domain.centralStaff.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.product.web.domain.centralStaff.converter.CentralStaffConverter;
import umc.product.web.domain.centralStaff.dto.CentralStaffResponseDTO;
import umc.product.web.domain.centralStaff.entity.CentralStaff;
import umc.product.web.domain.centralStaff.repository.CentralStaffRepository;
import umc.product.web.domain.centralStaff.service.CentralStaffQueryService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class CentralStaffQueryServiceImpl implements CentralStaffQueryService {

    private final CentralStaffRepository centralStaffRepository;

    @Override
    public CentralStaffResponseDTO.CentralStaffListDTO getCentralStaffList(Integer generation, Long cursor, Integer take) {

        Pageable pageable = PageRequest.of(0, take, Sort.by("id").ascending());
        Slice<CentralStaff> centralStaffSlice = centralStaffRepository.findByGenerationWithPageable(
                generation, cursor, pageable
        );

        Long nextCursor = centralStaffSlice.hasNext() && !centralStaffSlice.getContent().isEmpty()
                ? centralStaffSlice.getContent().get(centralStaffSlice.getContent().size() - 1).getId()
                : null;

        return CentralStaffConverter.toCentralStaffListDTO(centralStaffSlice, nextCursor);
    }

    @Override
    public CentralStaffResponseDTO.GetGenerationListDTO getGenerationList() {

        List<Integer> generationList = centralStaffRepository.findDistinctGenerationList();
        return CentralStaffConverter.toGetGenerationListDTO(generationList);
    }
}
