package umc.product.web.domain.sponsor;

import jakarta.persistence.*;
import lombok.*;
import umc.product.web.global.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class RequestSponsor extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_sponsor_id")
    private Long id;

    @Column(name = "application_name")
    private String applicationName;

    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "email")
    private String email;

    @Column(name = "organization_name")
    private String organizationName;

    @Column(name = "logo_image")
    private String logoImage;

    @Column(name = "description", length = 3000)
    private String description;

    @Column(name = "link", nullable = false)
    private String link;
}
