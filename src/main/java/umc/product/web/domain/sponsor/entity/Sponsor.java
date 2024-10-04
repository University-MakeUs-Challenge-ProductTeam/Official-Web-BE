package umc.product.web.domain.sponsor.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.product.web.global.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Sponsor extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sponsor_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description", length = 3000)
    private String description;

    @Column(name = "url")
    private String url;

    @Column(name = "logo_image")
    private String logoImage;
}
