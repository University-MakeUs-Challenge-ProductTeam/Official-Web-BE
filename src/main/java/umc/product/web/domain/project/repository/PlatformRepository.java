package umc.product.web.domain.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.product.web.domain.project.entity.Platform;

public interface PlatformRepository extends JpaRepository<Platform, Long> {
}
