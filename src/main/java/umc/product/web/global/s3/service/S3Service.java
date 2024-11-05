package umc.product.web.global.s3.service;

import umc.product.web.global.s3.dto.S3Request.*;
import umc.product.web.global.s3.dto.S3Response.*;

public interface S3Service {

    PresignedUrlToUploadResponse getPresignedUrlToUpload(GetPresignedUrlRequest request);

    PresignedUrlListToUploadResponse getPresignedUrlListToUpload(GetPresignedUrlListRequest request);

    Boolean isExistKeyName(String keyName);

    String generateStaticUrl(String keyName);
}
