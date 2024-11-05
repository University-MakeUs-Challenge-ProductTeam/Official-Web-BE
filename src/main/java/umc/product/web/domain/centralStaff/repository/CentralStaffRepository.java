package umc.product.web.domain.centralStaff.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.product.web.domain.centralStaff.entity.CentralStaff;

import java.util.List;

public interface CentralStaffRepository extends JpaRepository<CentralStaff, Long> {

    @Query("SELECT cs FROM CentralStaff cs " +
            "WHERE (:generation IS NULL OR cs.generation = :generation) " +
            "ORDER BY cs.generation DESC, cs.id DESC ")
    Page<CentralStaff> findByGenerationWithPageable(
            @Param("generation") Integer generation,
            Pageable pageable);

    @Query("SELECT DISTINCT cs.generation FROM CentralStaff cs ORDER BY cs.generation")
    List<Integer> findDistinctGenerationList();
}
