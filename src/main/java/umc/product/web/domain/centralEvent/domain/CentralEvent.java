package umc.product.web.domain.centralEvent.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import umc.product.web.global.common.BaseEntity;

public class CentralEvent extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "central_event_id")
    private Long id;

    @Column(name = "event_image_url")
    private String eventImageUrl;

    @Column(name = "description", nullable = false)
    private String description;
}
