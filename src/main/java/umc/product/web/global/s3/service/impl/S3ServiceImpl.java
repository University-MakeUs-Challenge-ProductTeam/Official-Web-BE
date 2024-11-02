package umc.product.web.global.s3.service.impl;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import umc.product.web.global.s3.dto.S3Request.*;
import umc.product.web.global.s3.dto.S3Response.*;
import umc.product.web.global.s3.service.S3Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static umc.product.web.global.s3.converter.S3Converter.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class S3ServiceImpl implements S3Service {

    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Override
    public PresignedUrlToUploadResponse getPresignedUrlToUpload(GetPresignedUrlRequest request) {

        Date expiration = new Date();
        long expTime = expiration.getTime();
        expTime += TimeUnit.MINUTES.toMillis(3);
        expiration.setTime(expTime);

        String keyName = UUID.randomUUID() + "_" + request.getFileName();

        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucket, keyName)
                .withMethod(HttpMethod.PUT)
                .withExpiration(expiration);

        String key = generatePresignedUrlRequest.getKey();

        return toPresignedUrlToUploadResponse(amazonS3.generatePresignedUrl(generatePresignedUrlRequest).toString(), key);
    }

    @Override
    public PresignedUrlListToUploadResponse getPresignedUrlListToUpload(GetPresignedUrlListRequest request) {

        Date expiration = new Date();
        long expTime = expiration.getTime();
        expTime += TimeUnit.MINUTES.toMillis(3);
        expiration.setTime(expTime);

        List<PresignedUrlToUploadResponse> responseList = request.getFileNameList().stream()
                .map(oldKeyName -> {
                    String keyName = UUID.randomUUID() + "_" + oldKeyName;

                    GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucket, keyName)
                            .withMethod(HttpMethod.PUT)
                            .withExpiration(expiration);

                    String key = generatePresignedUrlRequest.getKey();

                    return toPresignedUrlToUploadResponse(amazonS3.generatePresignedUrl(generatePresignedUrlRequest).toString(), key);
                }).collect(Collectors.toList());

        return toPresignedUrlListToUploadResponse(responseList);
    }

    @Override
    public Boolean isExistKeyName(String keyName) {
        return amazonS3.doesObjectExist(bucket, keyName);
    }

    @Override
    public String generateStaticUrl(String keyName) {
        return "https://" + bucket + ".s3." + amazonS3.getRegionName() + ".amazonaws.com/" + keyName;
    }
}
