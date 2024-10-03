package umc.product.web.domain.sponsor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.product.web.domain.sponsor.entity.Sponsor;

public interface SponsorRepository extends JpaRepository<Sponsor, Long> {
}
