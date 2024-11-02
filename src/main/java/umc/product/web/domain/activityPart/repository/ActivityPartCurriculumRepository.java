package umc.product.web.domain.activityPart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.product.web.domain.activityPart.entity.ActivityPartCurriculum;

import java.util.List;

public interface ActivityPartCurriculumRepository extends JpaRepository<ActivityPartCurriculum, Long> {

    List<ActivityPartCurriculum> findAllByActivityPartId(Long activityPartId);
}
