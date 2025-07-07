package com.unis.admin.service;

import com.unis.admin.dto.*;
import com.unis.common.domain.Project;
import com.unis.common.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ArrayList<GetProjectsResponse> getProjects() {
        return null;
    }

    public PostProjectResponse postProject(PostProjectRequest request, String imageUrl) {
        Project project = new Project(
            null,
            imageUrl,
            request.getServiceName(),
            request.getShortDescription(),
            request.getDescription(),
            request.getGithubUrl(),
            request.getInstagramUrl(),
            request.getGeneration(),
            false
        );
        Project saved = projectRepository.save(project);
        return (saved != null)?
            new PostProjectResponse(saved.getProjectId()):
            null;
    }

    public GetProjectResponse getProject(Integer projectId) {
        Project project = projectRepository.findById(projectId)
            .orElseThrow(()  -> new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다."));
        if (project.getIsDeleted()) throw new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다.");
        return new GetProjectResponse(
            project.getImageUrl(),
            project.getServiceName(),
            project.getShortDescription(),
            project.getDescription(),
            project.getGithubUrl(),
            project.getInstagramUrl(),
            project.getGeneration()
        );
    }

    public void putProject(Integer projectId, PutProjectRequest request, String imageUrl) {
        Project project = projectRepository.findById(projectId)
            .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다."));
        if (project.getIsDeleted()) throw new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다.");

        request.applyTo(project, imageUrl);
        projectRepository.save(project);
    }

    public void deleteProject(Integer projectId) {
        Project project = projectRepository.findById(projectId)
            .orElseThrow(() ->  new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다."));
        project.setIsDeleted(true);
        projectRepository.save(project);
    }
}
