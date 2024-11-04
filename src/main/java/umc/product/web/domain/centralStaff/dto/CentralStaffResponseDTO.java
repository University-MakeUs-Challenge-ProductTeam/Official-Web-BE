package umc.product.web.domain.centralStaff.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class CentralStaffResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProfileLinkDTO {
        private Long profileLinkId;
        private String linkType;
        private String linkUrl;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CentralStaffDTO {
        private Long centralStaffId;
        private String nickname;
        private String role;
        private String school;
        private String introduction;
        private String profileImageUrl;
        private Integer generation;
        private List<ProfileLinkDTO> profileLinkList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CentralStaffListDTO {
        private List<CentralStaffDTO> centralStaffList;
        private Boolean hasNext;
        private Long nextCursor;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetGenerationListDTO {
        private List<Integer> generationList;
    }
}
