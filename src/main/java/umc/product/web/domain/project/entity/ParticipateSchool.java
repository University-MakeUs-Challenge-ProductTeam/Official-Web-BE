package umc.product.web.domain.project.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.product.web.global.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ParticipateSchool extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participate_school_id")
    private Long id;

    private String name;
}
