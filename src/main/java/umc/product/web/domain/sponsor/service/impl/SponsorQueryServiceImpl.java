package umc.product.web.domain.sponsor.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.product.web.domain.sponsor.converter.SponsorConverter;
import umc.product.web.domain.sponsor.dto.SponsorResponseDTO;
import umc.product.web.domain.sponsor.entity.Sponsor;
import umc.product.web.domain.sponsor.repository.SponsorRepository;
import umc.product.web.domain.sponsor.service.SponsorQueryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SponsorQueryServiceImpl implements SponsorQueryService {

    private final SponsorRepository sponsorRepository;

    @Override
    public SponsorResponseDTO.SponsorListDTO getSponsors() {
        List<Sponsor> sponsors = sponsorRepository.findAll();
        return SponsorConverter.toSponsorListDTO(sponsors);
    }
}
