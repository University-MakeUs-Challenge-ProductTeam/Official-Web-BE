package umc.product.web.global.s3.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.product.web.global.common.BaseResponse;
import umc.product.web.global.s3.dto.S3Request.*;
import umc.product.web.global.s3.dto.S3Response.*;
import umc.product.web.global.s3.service.S3Service;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/s3")
@Tag(name = "S3 관련")
public class S3Controller {

    private final S3Service s3Service;

    @Operation(summary = "파일 업로드용 presignedUrl 생성 요청", description = "파일 업로드를 위한 presignedUrl 생성을 요청하는 API 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    @GetMapping("/presigned/upload")
    public BaseResponse<PresignedUrlToUploadResponse> getPresignedUrlToUpload(
            @RequestBody GetPresignedUrlRequest request
    ) {
        return BaseResponse.onSuccess(s3Service.getPresignedUrlToUpload(request));
    }

    @Operation(summary = "파일 업로드용 presignedUrl 생성 요청 (여러 파일)", description = "여러 파일들에 대한 presignedUrl 생성을 요청하는 API 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    @GetMapping("/presigned/upload/files")
    public BaseResponse<PresignedUrlListToUploadResponse> getPresignedUrListlToUpload(
            @RequestBody GetPresignedUrlListRequest request
    ) {
        return BaseResponse.onSuccess(s3Service.getPresignedUrlListToUpload(request));
    }
}

