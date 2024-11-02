package umc.product.web.domain.centralEvent.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.product.web.domain.centralEvent.domain.enums.EventType;

public class CentralEventResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CentralEventInfoDTO {
        private Long id;
        private String eventImageUrl;
        private String description;
        private EventType eventType;
    }
}
