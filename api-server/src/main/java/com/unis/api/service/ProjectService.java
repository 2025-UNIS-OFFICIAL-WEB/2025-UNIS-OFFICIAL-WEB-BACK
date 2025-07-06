package com.unis.api.service;

import com.unis.api.dto.GetProjectResponse;
import com.unis.api.dto.GetProjectsResponse;
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

    public GetProjectResponse getProject(Integer projectId) {
        return null;
    }
}
