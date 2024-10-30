package umc.product.web.domain.activityPart.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.product.web.domain.activityPart.entity.enums.Part;
import umc.product.web.global.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ActivityPart extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_part_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "part_name", nullable = false)
    private Part partName;

    @Column(name = "require_skill")
    private String requireSkill;
}
