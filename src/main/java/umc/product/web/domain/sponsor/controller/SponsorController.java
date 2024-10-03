package umc.product.web.domain.sponsor.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.product.web.domain.sponsor.service.SponsorCommandService;
import umc.product.web.domain.sponsor.service.SponsorQueryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sponsors")
public class SponsorController {

    private final SponsorCommandService sponsorCommandService;
    private final SponsorQueryService sponsorQueryService;
}
