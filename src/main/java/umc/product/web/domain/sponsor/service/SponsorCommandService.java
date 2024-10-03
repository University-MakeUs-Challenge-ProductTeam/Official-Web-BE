package umc.product.web.domain.sponsor.service;

import umc.product.web.domain.sponsor.dto.SponsorRequestDTO;
import umc.product.web.domain.sponsor.dto.SponsorResponseDTO;

public interface SponsorCommandService {
    void deleteSponsor(Long sponsorId);

    SponsorResponseDTO.CreateSponsorResultDTO createSponsor(SponsorRequestDTO.CreateSponsorDTO createSponsorDTO);
}
