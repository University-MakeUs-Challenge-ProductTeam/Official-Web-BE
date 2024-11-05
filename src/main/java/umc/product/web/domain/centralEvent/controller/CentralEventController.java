package umc.product.web.domain.centralEvent.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.product.web.domain.centralEvent.converter.CentralEventConverter;
import umc.product.web.domain.centralEvent.domain.CentralEvent;
import umc.product.web.domain.centralEvent.domain.enums.EventType;
import umc.product.web.domain.centralEvent.dto.CentralEventResponseDTO;
import umc.product.web.domain.centralEvent.service.CentralEventService;
import umc.product.web.global.common.BaseResponse;
import umc.product.web.global.error.code.ErrorReasonDTO;
import umc.product.web.global.error.code.status.ErrorStatus;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "주요활동 API")
public class CentralEventController {

    private final CentralEventService centralEventService;

    @Operation(summary = "주요 활동 조회 API", description = "주요 활동 타입에 맞추어서 조회를 합니다. _by 제이미_")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "COMMON200",
                    description = "OK, 성공"
            ),
            @ApiResponse(
                    responseCode = "CENTRAL_EVENT001",
                    description = "CENTRAL EVENT가 존재하지 않습니다.",
                    content = @Content(schema = @Schema(implementation = ErrorReasonDTO.class))
            ),
    })
    @GetMapping("/central-events")
    public BaseResponse<CentralEventResponseDTO.CentralEventInfoDTO> getCentralEvent(
            @RequestParam(name = "eventType") EventType eventType
    ) {
        CentralEvent centralEvent = centralEventService.getCentralEvent(eventType);
        return BaseResponse.onSuccess(CentralEventConverter.toCentralEventInfoDTO(centralEvent));
    }
}
