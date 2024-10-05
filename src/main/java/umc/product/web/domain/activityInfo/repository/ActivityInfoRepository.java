package umc.product.web.domain.activityInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.product.web.domain.activityInfo.entity.ActivityInfo;

import java.util.Optional;

public interface ActivityInfoRepository extends JpaRepository<ActivityInfo, Long> {

    Optional<ActivityInfo> findTopByOrderByGenerationDesc();
}
