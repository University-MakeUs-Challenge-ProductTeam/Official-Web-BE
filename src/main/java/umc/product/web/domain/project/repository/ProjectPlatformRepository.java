package umc.product.web.domain.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.product.web.domain.project.entity.ProjectPlatform;

public interface ProjectPlatformRepository extends JpaRepository<ProjectPlatform, Long> {
}
