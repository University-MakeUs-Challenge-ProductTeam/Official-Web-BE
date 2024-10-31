package umc.product.web.domain.centralEvent.service;

import org.springframework.web.bind.annotation.RequestParam;
import umc.product.web.domain.centralEvent.domain.CentralEvent;
import umc.product.web.domain.centralEvent.domain.enums.EventType;

public interface CentralEventService {

    CentralEvent getCentralEvent(EventType eventType);
}
