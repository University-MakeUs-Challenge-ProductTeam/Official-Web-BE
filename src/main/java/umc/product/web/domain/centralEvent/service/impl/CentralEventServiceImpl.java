package umc.product.web.domain.centralEvent.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.product.web.domain.centralEvent.domain.CentralEvent;
import umc.product.web.domain.centralEvent.domain.enums.EventType;
import umc.product.web.domain.centralEvent.repository.CentralEventRepository;
import umc.product.web.domain.centralEvent.service.CentralEventService;
import umc.product.web.global.error.code.handler.CentralEventHandler;
import umc.product.web.global.error.code.status.ErrorStatus;

@Service
@RequiredArgsConstructor
public class CentralEventServiceImpl implements CentralEventService {

    private final CentralEventRepository centralEventRepository;


    @Override
    public CentralEvent getCentralEvent(EventType eventType) {
        return centralEventRepository.findByEventType(eventType).orElseThrow(()-> new CentralEventHandler(ErrorStatus.CENTRAL_EVENT_NOT_FOUND));
    }
}
