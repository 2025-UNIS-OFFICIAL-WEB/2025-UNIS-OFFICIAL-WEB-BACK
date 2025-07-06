package com.unis.admin.service;

import com.unis.admin.dto.*;
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

    public PostProjectResponse postProject(PostProjectRequest request) {
        return null;
    }

    public GetProjectResponse getProject(Integer projectId) {
        return null;
    }

    public PutProjectResponse putProject(Integer projectId, PutProjectRequest request) {
        return null;
    }

    public DeleteProjectResponse deleteProject(Integer projectId) {
        return null;
    }
}
