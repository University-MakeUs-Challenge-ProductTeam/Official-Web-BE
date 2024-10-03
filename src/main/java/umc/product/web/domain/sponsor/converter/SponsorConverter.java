package umc.product.web.domain.sponsor.converter;

import umc.product.web.domain.sponsor.dto.SponsorRequestDTO;
import umc.product.web.domain.sponsor.dto.SponsorResponseDTO;
import umc.product.web.domain.sponsor.entity.Sponsor;

import java.util.List;

public class SponsorConverter {

    public static SponsorResponseDTO.SponsorDTO toSponsorDTO(Sponsor sponsor) {
        return SponsorResponseDTO.SponsorDTO.builder()
                .sponsorId(sponsor.getId())
                .title(sponsor.getTitle())
                .description(sponsor.getDescription())
                .url(sponsor.getUrl())
                .logoUrl(sponsor.getLogoImage())
                .build();
    }

    public static SponsorResponseDTO.SponsorListDTO toSponsorListDTO(List<Sponsor> sponsors) {

        List<SponsorResponseDTO.SponsorDTO> sponsorList = sponsors.stream().map(SponsorConverter::toSponsorDTO).toList();

        return SponsorResponseDTO.SponsorListDTO.builder()
                .sponsorList(sponsorList)
                .build();
    }

    public static Sponsor toSponsor(SponsorRequestDTO.CreateSponsorDTO createSponsorDTO) {
        return Sponsor.builder()
                .url(createSponsorDTO.getUrl())
                .title(createSponsorDTO.getTitle())
                .logoImage(createSponsorDTO.getLogoImageUrl())
                .description(createSponsorDTO.getDescription())
                .logoImage(createSponsorDTO.getLogoImageUrl())
                .build();
    }

    public static SponsorResponseDTO.CreateSponsorResultDTO toCreateSponsorResultDTO(Sponsor sponsor) {
        return SponsorResponseDTO.CreateSponsorResultDTO.builder()
                .sponsorId(sponsor.getId())
                .createdAt(sponsor.getCreatedAt())
                .updatedAt(sponsor.getUpdatedAt())
                .build();
    }
}
