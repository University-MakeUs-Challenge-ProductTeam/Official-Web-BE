package umc.product.web.global.s3.converter;

import umc.product.web.global.s3.dto.S3Response.*;

import java.util.List;

public class S3Converter {

    public static PresignedUrlToUploadResponse toPresignedUrlToUploadResponse(String url, String keyName) {
        return PresignedUrlToUploadResponse.builder()
                .url(url)
                .keyName(keyName)
                .build();
    }

    public static PresignedUrlListToUploadResponse toPresignedUrlListToUploadResponse(List<PresignedUrlToUploadResponse> responseList) {
        return PresignedUrlListToUploadResponse.builder()
                .presignedUrlListToUpload(responseList)
                .build();
    }
}
