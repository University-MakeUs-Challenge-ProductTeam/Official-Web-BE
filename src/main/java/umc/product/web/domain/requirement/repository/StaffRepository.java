package umc.product.web.domain.requirement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.product.web.domain.requirement.entity.RequirementSchool;
import umc.product.web.domain.requirement.entity.Staff;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    List<Staff> findByRequirementSchool(RequirementSchool requirementSchool);
}
