package umc.product.web.domain.requirement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.product.web.domain.requirement.entity.RequirementPart;
import umc.product.web.domain.requirement.entity.RequirementSchool;

import java.util.List;

public interface RequirementPartRepository extends JpaRepository<RequirementPart, Long> {

    List<RequirementPart> findByRequirementSchool(RequirementSchool requirementSchool);

}
