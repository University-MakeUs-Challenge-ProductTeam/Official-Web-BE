package umc.product.web.domain.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.product.web.domain.project.entity.ProjectMember;

import java.util.List;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long> {

    List<ProjectMember> findAllByProjectId(Long projectId);
}
