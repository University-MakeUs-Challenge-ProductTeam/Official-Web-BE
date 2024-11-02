package umc.product.web.domain.centralEvent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.product.web.domain.centralEvent.domain.CentralEvent;
import umc.product.web.domain.centralEvent.domain.enums.EventType;

import java.util.Optional;

public interface CentralEventRepository extends JpaRepository<CentralEvent, Long> {
    Optional<CentralEvent> findByEventType(EventType eventType);
}
