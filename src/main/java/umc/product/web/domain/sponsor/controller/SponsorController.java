package umc.product.web.domain.sponsor.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.product.web.domain.sponsor.dto.SponsorResponseDTO;
import umc.product.web.domain.sponsor.service.SponsorCommandService;
import umc.product.web.domain.sponsor.service.SponsorQueryService;
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

    @DeleteMapping("/{sponsorId}")
    public BaseResponse<Void> deleteSponsor(@PathVariable Long sponsorId) {
        sponsorCommandService.deleteSponsor(sponsorId);
        return BaseResponse.onSuccess(null);
    }
}
