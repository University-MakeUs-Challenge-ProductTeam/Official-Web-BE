package umc.product.web.domain.sponsor.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.product.web.domain.sponsor.dto.SponsorResponseDTO;
import umc.product.web.domain.sponsor.dto.SponsorResponseDTO.SponsorDTO;
import umc.product.web.domain.sponsor.service.SponsorCommandService;
import umc.product.web.domain.sponsor.service.SponsorQueryService;
import umc.product.web.global.common.BaseEntity;
import umc.product.web.global.common.BaseResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sponsors")
public class SponsorController {

    private final SponsorCommandService sponsorCommandService;
    private final SponsorQueryService sponsorQueryService;

    @GetMapping("")
    public BaseResponse<SponsorResponseDTO.SponsorListDTO> getSponsors() {
        SponsorResponseDTO.SponsorListDTO sponsorListDTO = sponsorQueryService.getSponsors();
        return BaseResponse.onSuccess(sponsorListDTO);
    }
}
