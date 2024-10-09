package umc.product.web.domain.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.product.web.domain.project.entity.ProjectParticipateSchool;

import java.util.List;

public interface ProjectParticipateSchoolRepository extends JpaRepository<ProjectParticipateSchool, Long> {

    @Query("SELECT pps FROM ProjectParticipateSchool pps " +
            "JOIN FETCH pps.participateSchool ps " +
            "JOIN FETCH pps.project p " +
            "WHERE p.id = :projectId")
    List<ProjectParticipateSchool> findAllWithParticipateSchoolByProjectId(@Param("projectId") Long projectId);
}
