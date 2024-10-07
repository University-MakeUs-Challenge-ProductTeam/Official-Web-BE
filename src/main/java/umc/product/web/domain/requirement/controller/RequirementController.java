package umc.product.web.domain.requirement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.product.web.domain.requirement.dto.RequirementResponseDTO;
import umc.product.web.domain.requirement.service.RequirementQueryService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/requirements")
public class RequirementController {

    public final RequirementQueryService requirementQueryService;

    @GetMapping("")
    public RequirementResponseDTO.RequirementInfoDTO getRequirementInfo(@RequestParam("name") String name) {
        return requirementQueryService.getRequirementInfo(name);
    }

}
