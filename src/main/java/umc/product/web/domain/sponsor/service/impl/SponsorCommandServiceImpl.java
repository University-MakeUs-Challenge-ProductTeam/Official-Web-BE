package umc.product.web.domain.sponsor.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.product.web.domain.sponsor.converter.SponsorConverter;
import umc.product.web.domain.sponsor.dto.SponsorRequestDTO;
import umc.product.web.domain.sponsor.dto.SponsorResponseDTO;
import umc.product.web.domain.sponsor.entity.Sponsor;
import umc.product.web.domain.sponsor.repository.SponsorRepository;
import umc.product.web.domain.sponsor.service.SponsorCommandService;

@Service
@RequiredArgsConstructor
@Transactional
public class SponsorCommandServiceImpl implements SponsorCommandService {

    private final SponsorRepository sponsorRepository;

    @Override
    public void deleteSponsor(Long sponsorId) {
        sponsorRepository.deleteById(sponsorId);
    }

    @Override
    public SponsorResponseDTO.CreateSponsorResultDTO createSponsor(SponsorRequestDTO.CreateSponsorDTO createSponsorDTO) {
        Sponsor createdSponsor = sponsorRepository.save(SponsorConverter.toSponsor(createSponsorDTO));
        return SponsorConverter.toCreateSponsorResultDTO(createdSponsor);
    }
}
