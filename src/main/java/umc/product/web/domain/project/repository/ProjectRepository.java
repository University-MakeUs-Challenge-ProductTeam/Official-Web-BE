package umc.product.web.domain.project.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.product.web.domain.project.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p FROM Project p " +
            "JOIN FETCH p.projectPlatforms pp " +
            "JOIN FETCH pp.platform " +
            "WHERE p.isReleased = true " +
            "AND p.id > :cursor")
    Slice<Project> findReleasedProjectsWithPlatform(
            @Param("cursor") Long cursor,
            Pageable pageable);
}
