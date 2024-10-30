package umc.product.web.domain.project.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.product.web.domain.project.converter.ProjectConverter;
import umc.product.web.domain.project.dto.ProjectResponseDTO;
import umc.product.web.domain.project.entity.Project;
import umc.product.web.domain.project.entity.ProjectMember;
import umc.product.web.domain.project.entity.ProjectParticipateSchool;
import umc.product.web.domain.project.entity.enums.PlatformName;
import umc.product.web.domain.project.repository.ProjectMemberRepository;
import umc.product.web.domain.project.repository.ProjectParticipateSchoolRepository;
import umc.product.web.domain.project.repository.ProjectRepository;
import umc.product.web.domain.project.repository.ParticipateSchoolRepository;
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
    private final ParticipateSchoolRepository participateSchoolRepository;
    private final ProjectMemberRepository projectMemberRepository;
    private final ProjectParticipateSchoolRepository projectParticipateSchoolRepository;

    @Override
    public ProjectResponseDTO.ReleasedProjectListDTO getReleasedProjects(Long cursor, Integer take) {

        Long startCursor = (cursor == 1) ? 0L : cursor;
        Pageable pageable = PageRequest.of(0, take);
        Slice<Project> projectSlice = projectRepository.findReleasedProjectsWithPlatform(startCursor, pageable);
        Long nextCursor = projectSlice.hasNext() && !projectSlice.getContent().isEmpty()
                ? projectSlice.getContent().get(projectSlice.getNumberOfElements() - 1).getId()
                : null;

        return ProjectConverter.toReleasedProjectListDTO(projectSlice, nextCursor);
    }

    @Override
    public ProjectResponseDTO.UMCProjectListDTO getUMCProjects(Integer generation, PlatformName platformName, Long cursor, Integer take) {

        Long startCursor = (cursor == 1) ? 0L : cursor;
        Pageable pageable = PageRequest.of(0, take);
        Slice<Project> projectSlice = projectRepository.findProjectsByPlatform(generation, platformName, startCursor, pageable);
        Long nextCursor = projectSlice.hasNext() && !projectSlice.getContent().isEmpty()
                ? projectSlice.getContent().get(projectSlice.getNumberOfElements() - 1).getId()
                : null;

        return ProjectConverter.toUMCProjectListDTO(projectSlice, nextCursor);
    }

    @Override
    public ProjectResponseDTO.ProjectDetailDTO getProjectDetail(Long projectId) {

        List<ProjectParticipateSchool> projectParticipateSchoolList = projectParticipateSchoolRepository.findAllWithParticipateSchoolByProjectId(projectId);
        List<ProjectMember> projectMemberList = projectMemberRepository.findAllByProjectId(projectId);
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectHandler(PROJECT_NOT_FOUND));

        return ProjectConverter.toProjectDetailDTO(project, projectParticipateSchoolList, projectMemberList);
    }
}
