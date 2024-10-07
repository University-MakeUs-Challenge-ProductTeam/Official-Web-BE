package umc.product.web.domain.requirement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.product.web.domain.requirement.entity.RequirementSchool;

import java.util.Optional;

public interface RequirementSchoolRepository extends JpaRepository<RequirementSchool, Long> {

    Optional<RequirementSchool> findByName(String name);
}
