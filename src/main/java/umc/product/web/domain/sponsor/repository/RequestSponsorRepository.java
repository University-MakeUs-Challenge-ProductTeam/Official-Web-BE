package umc.product.web.domain.sponsor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.product.web.domain.sponsor.entity.RequestSponsor;

public interface RequestSponsorRepository extends JpaRepository<RequestSponsor, Long> {
}
