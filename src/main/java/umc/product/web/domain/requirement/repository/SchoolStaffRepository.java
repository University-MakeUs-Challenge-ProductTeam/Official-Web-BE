package umc.product.web.domain.requirement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.product.web.domain.requirement.entity.RequirementSchool;
import umc.product.web.domain.requirement.entity.SchoolStaff;

import java.util.List;

public interface SchoolStaffRepository extends JpaRepository<SchoolStaff, Long> {
    List<SchoolStaff> findByRequirementSchool(RequirementSchool requirementSchool);
}
