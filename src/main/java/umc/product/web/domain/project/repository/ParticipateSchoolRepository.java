package umc.product.web.domain.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.product.web.domain.project.entity.ParticipateSchool;

import java.util.List;

public interface ParticipateSchoolRepository extends JpaRepository<ParticipateSchool, Long> {

    List<ParticipateSchool> findAllByProjectId(Long projectId);
}
