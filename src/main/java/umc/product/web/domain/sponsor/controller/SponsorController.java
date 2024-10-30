package umc.product.web.domain.sponsor.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.product.web.domain.sponsor.dto.SponsorRequestDTO;
import umc.product.web.domain.sponsor.dto.SponsorResponseDTO;
import umc.product.web.domain.sponsor.service.SponsorCommandService;
import umc.product.web.domain.sponsor.service.SponsorQueryService;
import umc.product.web.global.common.BaseResponse;
import umc.product.web.global.error.code.ErrorReasonDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sponsors")
public class SponsorController {

    private final SponsorCommandService sponsorCommandService;
    private final SponsorQueryService sponsorQueryService;

    @Operation(summary = "후원사 조회 API", description = "후원사 정보를 조회 합니다. _by 제이미_")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "COMMON200",
                    description = "OK, 성공"
            ),
            @ApiResponse(
                    responseCode = "SPONSOR001",
                    description = "SPONSOR가 존재하지 않습니다.",
                    content = @Content(schema = @Schema(implementation = ErrorReasonDTO.class))
            ),
    })
    @GetMapping("")
    public BaseResponse<SponsorResponseDTO.SponsorListDTO> getSponsors() {
        SponsorResponseDTO.SponsorListDTO sponsorListDTO = sponsorQueryService.getSponsors();
        return BaseResponse.onSuccess(sponsorListDTO);
    }

//    @DeleteMapping("/{sponsorId}")
//    public BaseResponse<Void> deleteSponsor(@PathVariable Long sponsorId) {
//        sponsorCommandService.deleteSponsor(sponsorId);
//        return BaseResponse.onSuccess(null);
//    }
//
//    @PostMapping("")
//    public BaseResponse<SponsorResponseDTO.CreateSponsorResultDTO> createSponsor(@RequestBody SponsorRequestDTO.CreateSponsorDTO createSponsorDTO) {
//        SponsorResponseDTO.CreateSponsorResultDTO createSponsorResultDTO = sponsorCommandService.createSponsor(createSponsorDTO);
//        return BaseResponse.onSuccess(createSponsorResultDTO);
//    }

    @Operation(summary = "후원사 신청 API", description = "후원사에 신청 합니다. _by 제이미_")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "COMMON200",
                    description = "OK, 성공"
            ),
    })
    @PostMapping("/request")
    public BaseResponse<SponsorResponseDTO.CreateRequestSponsorResultDTO> requestSponsor(@RequestBody SponsorRequestDTO.CreateRequestSponsorDTO createRequestSponsorDTO) {
        SponsorResponseDTO.CreateRequestSponsorResultDTO createRequestSponsorResultDTO = sponsorCommandService.requestSponsor(createRequestSponsorDTO);
        return BaseResponse.onSuccess(createRequestSponsorResultDTO);
    }
}
