package umc.product.web.domain.project.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.product.web.domain.project.converter.ProjectConverter;
import umc.product.web.domain.project.dto.ProjectResponseDTO;
import umc.product.web.domain.project.entity.Platform;
import umc.product.web.domain.project.entity.Project;
import umc.product.web.domain.project.entity.ProjectMember;
import umc.product.web.domain.project.entity.ProjectParticipateSchool;
import umc.product.web.domain.project.entity.enums.PlatformName;
import umc.product.web.domain.project.repository.PlatformRepository;
import umc.product.web.domain.project.repository.ProjectMemberRepository;
import umc.product.web.domain.project.repository.ProjectParticipateSchoolRepository;
import umc.product.web.domain.project.repository.ProjectRepository;
import umc.product.web.domain.project.service.ProjectQueryService;
import umc.product.web.global.error.code.handler.ProjectHandler;

import java.util.List;

import static umc.product.web.global.error.code.status.ErrorStatus.PROJECT_NOT_FOUND;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ProjectQueryServiceImpl implements ProjectQueryService {

    private final ProjectRepository projectRepository;
    private final ProjectMemberRepository projectMemberRepository;
    private final ProjectParticipateSchoolRepository projectParticipateSchoolRepository;
    private final PlatformRepository platformRepository;

    @Override
    public ProjectResponseDTO.ReleasedProjectListDTO getReleasedProjects(int page, int size) {

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Project> projectPage = projectRepository.findReleasedProjectsWithPlatform(pageRequest);

        return ProjectConverter.toReleasedProjectListDTO(projectPage);
    }

    @Override
    public ProjectResponseDTO.UMCProjectListDTO getUMCProjects(Integer generation, PlatformName platformName, String searchTerm, int page, int size) {

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Project> projectPage = projectRepository.findProjectsByGenerationAndPlatformNameWithPageable(generation, platformName, searchTerm, pageRequest);

        return ProjectConverter.toUMCProjectListDTO(projectPage);
    }

    @Override
    public ProjectResponseDTO.ProjectDetailDTO getProjectDetail(Long projectId) {

        List<ProjectParticipateSchool> projectParticipateSchoolList = projectParticipateSchoolRepository.findAllWithParticipateSchoolByProjectId(projectId);
        List<ProjectMember> projectMemberList = projectMemberRepository.findAllByProjectId(projectId);
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectHandler(PROJECT_NOT_FOUND));

        return ProjectConverter.toProjectDetailDTO(project, projectParticipateSchoolList, projectMemberList);
    }

    @Override
    public ProjectResponseDTO.GetGenerationListDTO getGenerationList() {

        List<Integer> generationList = projectRepository.findDistinctGenerationList();
        return ProjectConverter.toGetGenerationListDTO(generationList);
    }

    @Override
    public ProjectResponseDTO.GetPlatformListDTO getPlatformList() {

        List<Platform> platformList = platformRepository.findAll();
        return ProjectConverter.toGetPlatformListDTO(platformList);
    }

    @Override
    public ProjectResponseDTO.GetTotalProjectListDTO getTotalProjectList() {

        List<Project> projectList = projectRepository.findAllByOrderByGenerationDesc();
        return ProjectConverter.toGetTotalProjectListDTO(projectList);
    }
}
