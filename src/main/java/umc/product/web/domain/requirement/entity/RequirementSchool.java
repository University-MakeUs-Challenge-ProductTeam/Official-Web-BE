package umc.product.web.domain.requirement.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.product.web.global.common.BaseEntity;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class RequirementSchool extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "requirement_school_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "submission_start")
    private LocalDate submissionStart;

    @Column(name = "submission_end")
    private LocalDate submissionEnd;

    @Column(name = "first_result_date")
    private LocalDate firstResultDate;

    @Column(name = "final_result_date")
    private LocalDate finalResultDate;

    @Column(name = "school_ot_date")
    private LocalDate schoolOtDate;

    @Column(name = "interview_start_date")
    private LocalDate interviewStartDate;

    @Column(name = "interview_end_date")
    private LocalDate interviewEndDate;
}
