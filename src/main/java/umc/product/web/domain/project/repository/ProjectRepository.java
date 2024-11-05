package umc.product.web.domain.project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.product.web.domain.project.entity.Project;
import umc.product.web.domain.project.entity.enums.PlatformName;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p FROM Project p " +
            "JOIN FETCH p.projectPlatforms pp " +
            "JOIN FETCH pp.platform " +
            "WHERE p.isReleased = true " +
            "ORDER BY p.generation DESC, p.id DESC ")
    Page<Project> findReleasedProjectsWithPlatform(Pageable pageable);

    @Query("SELECT DISTINCT p FROM Project p " +
            "JOIN p.projectPlatforms pp " +
            "JOIN pp.platform pf " +
            "WHERE (:generation IS NULL OR p.generation = :generation) " +
            "AND (:platformName IS NULL OR pf.platformName = :platformName) " +
            "AND (:searchTerm IS NULL OR p.name LIKE %:searchTerm%) " +
            "ORDER BY p.generation DESC, p.id DESC ")
    Page<Project> findProjectsByGenerationAndPlatformNameWithPageable(
            @Param("generation") Integer generation,
            @Param("platformName") PlatformName platformName,
            @Param("searchTerm") String searchTerm,
            Pageable pageable);

    @Query("SELECT DISTINCT p.generation FROM Project p ORDER BY p.generation")
    List<Integer> findDistinctGenerationList();

    List<Project> findAllByOrderByGenerationDesc();
}
