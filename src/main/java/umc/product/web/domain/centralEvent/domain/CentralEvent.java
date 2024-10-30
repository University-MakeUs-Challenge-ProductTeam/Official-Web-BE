package umc.product.web.domain.centralEvent.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.product.web.domain.centralEvent.domain.enums.EventType;
import umc.product.web.global.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CentralEvent extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "central_event_id")
    private Long id;

    @Column(name = "event_image_url")
    private String eventImageUrl;

    @Column(name = "description", nullable = false, length = 10000)
    private String description;

    @Enumerated(EnumType.STRING)
    private EventType eventType;
}
