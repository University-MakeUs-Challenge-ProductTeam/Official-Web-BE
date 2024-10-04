package umc.product.web.domain.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.product.web.domain.project.entity.enums.PlatformName;

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
        private String description;
        private String imageUrl;
        private List<PlatformName> platFormNameList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UMCProjectListDTO {
        private List<UMCProjectDTO> umcProjectDTOList;
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
        private String description;
        private String imageUrl;
        private List<PlatformName> platFormNameList;
    }
}
