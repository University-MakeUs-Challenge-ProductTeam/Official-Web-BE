package umc.product.web.domain.centralStaff.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.product.web.global.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ProfileLink extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_link_id")
    private Long id;

    @Column(name = "link_type", nullable = false)
    private String linkType;

    @Column(name = "link_url", nullable = false)
    private String linkUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "central_staff_id")
    private CentralStaff centralStaff;
}
