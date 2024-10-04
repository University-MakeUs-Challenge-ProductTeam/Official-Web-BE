package umc.product.web.domain.sponsor.service;

import umc.product.web.domain.sponsor.dto.SponsorResponseDTO;

public interface SponsorQueryService {

    SponsorResponseDTO.SponsorListDTO getSponsors();
}
