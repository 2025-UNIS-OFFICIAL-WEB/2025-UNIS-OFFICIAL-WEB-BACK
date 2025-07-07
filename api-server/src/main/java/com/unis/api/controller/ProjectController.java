package com.unis.api.controller;

import com.unis.api.dto.GetProjectResponse;
import com.unis.api.dto.GetProjectsResponse;
import com.unis.api.service.ProjectService;
import com.unis.common.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    @GetMapping("")
    public ResponseEntity<ApiResponse<?>> getProjects() {
        ArrayList<GetProjectsResponse> responses = projectService.getProjects();
        return (responses != null)?
            ResponseEntity.ok(ApiResponse.success(responses)):
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.error(500, "프로젝트 조회에 실패했습니다."));
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ApiResponse<?>> getProject(@PathVariable("projectId") Integer projectId) {
        GetProjectResponse response = projectService.getProject(projectId);
        return (response != null)?
            ResponseEntity.ok(ApiResponse.success(response)):
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.error(500, "프로젝트 조회에 실패했습니다."));
    }
}
