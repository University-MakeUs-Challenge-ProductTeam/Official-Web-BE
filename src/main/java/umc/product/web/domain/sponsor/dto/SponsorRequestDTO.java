package umc.product.web.domain.sponsor.dto;

import jakarta.validation.constraints.NotNull;
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

    @Getter
    public static class CreateRequestSponsorDTO {
        @Length(min = 1, max = 255)
        private String applicationName;
        @Length(min = 1, max = 255)
        private String contactInfo;
        @Length(min = 1, max = 255)
        private String email;
        @Length(min = 1, max = 255)
        private String organizationName;
        @Length(min = 1, max = 255)
        private String logoImage;
        @Length(min = 1, max = 300)
        private String description;
        @Length(min = 1, max = 255)
        @NotNull
        private String link;
    }


}
