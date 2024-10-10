package umc.product.web.global.s3.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

public class S3Response {

    @Schema(description = "AWS S3 URL 응답 정보")
    @Builder
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class PresignedUrlToUploadResponse {
        private String url;
        private String keyName;
    }

    @Schema(description = "AWS S3 URL 응답 정보 리스트")
    @Builder
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class PresignedUrlListToUploadResponse {
        private List<PresignedUrlToUploadResponse> presignedUrlListToUpload;
    }
}
