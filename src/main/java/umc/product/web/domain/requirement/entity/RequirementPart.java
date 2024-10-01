package umc.product.web.domain.requirement.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.product.web.domain.requirement.entity.enums.Part;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class RequirementPart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "requirement_part_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Part part;

    @Column(name = "require_skill")
    private String requireSkill;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requirement_school_id")
    private RequirementSchool requirementSchool;
}
