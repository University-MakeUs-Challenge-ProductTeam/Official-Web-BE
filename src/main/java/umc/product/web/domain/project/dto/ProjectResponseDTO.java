package umc.product.web.domain.project.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.product.web.domain.project.entity.enums.Part;
import umc.product.web.domain.project.entity.enums.PlatformName;

import java.time.LocalDate;
import java.util.List;

public class ProjectResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReleasedProjectListDTO {
        private List<ReleasedProjectDTO> releasedProjectDTOList;
        private Boolean hasNext;
        private Long nextCursor;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReleasedProjectDTO {
        private Long projectId;
        private String projectName;
        @Schema(description = "프로젝트 간단한 소개")
        private String description;
        @Schema(description = "프로젝트 로고 이미지 url")
        private String projectLogoImageUrl;
        @Schema(description = "출시된 플랫폼")
        private List<PlatformName> platFormNameList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UMCProjectListDTO {
        private List<UMCProjectDTO> umcProjectList;
        private Boolean hasNext;
        private Long nextCursor;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UMCProjectDTO {
        private Long projectId;
        private String projectName;
        @Schema(description = "프로젝트 간단한 소개")
        private String description;
        @Schema(description = "프로젝트 랜딩 이미지 url")
        private String projectLandingImageUrl;
        @Schema(description = "진행한 플랫폼")
        private List<PlatformName> platFormNameList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProjectDetailDTO {
        private Long projectId;
        private String projectName;
        private String projectLogoImageUrl;
        private String projectLandingImageUrl;
        private Integer generation;
        private List<String> projectSchoolList;
        private LocalDate startDate;
        private LocalDate endDate;
        private List<PlatformName> platFormNameList;
        private Boolean isReleased;
        private String description;
        private List<ProjectMemberDTO> projectMemberDTOList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProjectMemberDTO {
        private Long projectMemberId;
        private String nickname;
        private String name;
        private Part part;
    }
}
