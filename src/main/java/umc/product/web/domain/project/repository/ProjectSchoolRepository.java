package umc.product.web.domain.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.product.web.domain.project.entity.ProjectSchool;

import java.util.List;

public interface ProjectSchoolRepository extends JpaRepository<ProjectSchool, Long> {

    List<ProjectSchool> findAllByProjectId(Long projectId);
}
