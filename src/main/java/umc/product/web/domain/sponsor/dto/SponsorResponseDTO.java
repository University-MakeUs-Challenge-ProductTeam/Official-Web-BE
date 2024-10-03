package umc.product.web.domain.sponsor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.util.List;

public class SponsorResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SponsorListDTO {
        private List<SponsorDTO> sponsorList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SponsorDTO {
        private Long SponsorId;
        private String title;
        private String logoUrl;
        private String url;
        private String description;
    }

}
