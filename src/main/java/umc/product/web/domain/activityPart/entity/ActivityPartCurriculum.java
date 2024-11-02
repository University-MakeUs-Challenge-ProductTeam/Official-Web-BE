package umc.product.web.domain.activityPart.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.product.web.global.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ActivityPartCurriculum extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_part_curriculum_id")
    private Long id;

    @Column(name = "week", nullable = false)
    private Integer week;

    @Column(name = "topic", nullable = false)
    private String topic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activity_part_id")
    private ActivityPart activityPart;
}
