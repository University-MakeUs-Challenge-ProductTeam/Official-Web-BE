package umc.product.web.domain.sponsor.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.product.web.domain.sponsor.repository.SponsorRepository;
import umc.product.web.domain.sponsor.service.SponsorCommandService;

@Service
@RequiredArgsConstructor
public class SponsorCommandServiceImpl implements SponsorCommandService {

    private final SponsorRepository sponsorRepository;

    @Override
    public void deleteSponsor(Long sponsorId) {
        sponsorRepository.deleteById(sponsorId);
    }
}
