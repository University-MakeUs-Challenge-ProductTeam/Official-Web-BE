package umc.product.web.domain.centralEvent.converter;

import umc.product.web.domain.centralEvent.domain.CentralEvent;
import umc.product.web.domain.centralEvent.dto.CentralEventResponseDTO;

public class CentralEventConverter {

    public static CentralEventResponseDTO.CentralEventInfoDTO toCentralEventInfoDTO(CentralEvent centralEvent) {
        return CentralEventResponseDTO.CentralEventInfoDTO.builder()
                .id(centralEvent.getId())
                .description(centralEvent.getDescription())
                .eventImageUrl(centralEvent.getEventImageUrl())
                .eventType(centralEvent.getEventType())
                .build();
    }
}
