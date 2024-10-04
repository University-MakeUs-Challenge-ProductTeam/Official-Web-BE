package umc.product.web.domain.project.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.product.web.domain.project.entity.Project;
import umc.product.web.domain.project.entity.enums.PlatformName;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p FROM Project p " +
            "JOIN FETCH p.projectPlatforms pp " +
            "JOIN FETCH pp.platform " +
            "WHERE p.isReleased = true " +
            "AND p.id > :cursor")
    Slice<Project> findReleasedProjectsWithPlatform(
            @Param("cursor") Long cursor,
            Pageable pageable);

    @Query("SELECT DISTINCT p FROM Project p " +
            "JOIN p.projectPlatforms pp " +
            "JOIN pp.platform pf " +
            "WHERE (:generation IS NULL OR p.generation = :generation) " +
            "AND (:searchTerm IS NULL OR p.name LIKE %:searchTerm%) " +
            "AND (:platformName IS NULL OR pf.platformName = :platformName) " +
            "AND p.id > :cursor " +
            "ORDER BY p.id ASC")
    Slice<Project> findProjectsByPlatform(@Param("generation") Integer generation,
                                          @Param("searchTerm") String searchTerm,
                                          @Param("platformName") PlatformName platformName,
                                          @Param("cursor") Long cursor,
                                          Pageable pageable);
}
