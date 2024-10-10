package umc.product.web.global.s3.dto;

import lombok.Getter;

import java.util.List;

public class S3Request {

    @Getter
    public static class GetPresignedUrlRequest {
        private String fileName;
    }

    @Getter
    public static class GetPresignedUrlListRequest {
        private List<String> fileNameList;
    }
}
