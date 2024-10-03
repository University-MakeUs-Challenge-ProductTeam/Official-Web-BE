package umc.product.web.domain.sponsor.dto;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

public class SponsorRequestDTO {

    @Getter
    public static class CreateSponsorDTO {
        @Length(min = 1, max = 255)
        private String logoImageUrl;
        @Length(min = 1, max = 255)
        private String title;
        @Length(min = 1, max = 3000)
        private String description;
        @Length(min = 1, max = 255)
        private String url;
    }
}
