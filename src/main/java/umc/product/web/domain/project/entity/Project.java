package umc.product.web.domain.project.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.product.web.global.common.BaseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Project extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "generation", nullable = false)
    private Integer generation;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "is_released", nullable = false)
    private Boolean isReleased;

    @Column(name = "description", length = 3000)
    private String description;

    @Column(name = "project_logo_image_url")
    private String projectLogoImageUrl;

    @Column(name = "project_landing_image_url")
    private String projectLandingImageUrl;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<ProjectPlatform> projectPlatforms = new ArrayList<>();
}
