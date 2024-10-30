package umc.product.web.domain.centralStaff.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.product.web.domain.centralStaff.entity.CentralStaff;

public interface CentralStaffRepository extends JpaRepository<CentralStaff, Long> {

    @Query("SELECT cs FROM CentralStaff cs " +
            "WHERE (:generation IS NULL OR cs.generation = :generation) " +
            "AND (:cursor IS NULL OR cs.id > :cursor) " +
            "ORDER BY cs.id ASC")
    Slice<CentralStaff> findByGenerationWithPageable(
            @Param("generation") Integer generation,
            @Param("cursor") Long cursor,
            Pageable pageable);
}
