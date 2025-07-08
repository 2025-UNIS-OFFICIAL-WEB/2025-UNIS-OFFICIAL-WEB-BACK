package com.unis.api.service;

import com.unis.api.dto.GetProjectResponse;
import com.unis.api.dto.GetProjectsResponse;
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
        ArrayList<Project> projects = projectRepository.findByIsDeletedFalseOrderByGenerationDescProjectIdAsc();
        ArrayList<GetProjectsResponse> responses = new ArrayList<>();
        for (Project project : projects)
            responses.add(new GetProjectsResponse(
                project.getImageUrl(),
                project.getServiceName(),
                project.getShortDescription()
            ));
        return responses;
    }

    public GetProjectResponse getProject(Integer projectId) {
        Project project = projectRepository.findById(projectId)
            .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다."));
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
}
