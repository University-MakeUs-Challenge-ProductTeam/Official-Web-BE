package umc.product.web.domain.activityInfo.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.product.web.global.common.BaseEntity;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ActivityInfo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_info_id")
    private Long id;

    @Column(name = "generation")
    private Integer generation;

    @Column(name = "activity_start_date")
    private LocalDate activityStartDate;

    @Column(name = "activity_end_date")
    private LocalDate activityEndDate;

    @Column(name = "union_ot_date")
    private LocalDate unionOTDate;

    @Column(name = "club_fee")
    private Integer clubFee;

    @Column(name = "project_fee")
    private Integer projectFee;

    @Column(name = "project_payback_fee")
    private Integer projectPaybackFee;
}
