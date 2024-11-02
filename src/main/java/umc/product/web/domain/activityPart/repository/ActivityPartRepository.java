package umc.product.web.domain.activityPart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.product.web.domain.activityPart.entity.ActivityPart;
import umc.product.web.domain.activityPart.entity.enums.Part;

import java.util.Optional;

public interface ActivityPartRepository extends JpaRepository<ActivityPart, Long> {

    Optional<ActivityPart> findByPartName(Part partName);
}
