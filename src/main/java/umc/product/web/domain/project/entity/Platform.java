package umc.product.web.domain.project.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.product.web.domain.project.entity.enums.PlatformName;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "platfrom_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "platform_name", nullable = false)
    private PlatformName platformName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;
}
