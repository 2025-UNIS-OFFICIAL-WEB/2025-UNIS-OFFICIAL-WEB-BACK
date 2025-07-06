package com.unis.admin.controller;

import com.unis.admin.dto.*;
import com.unis.admin.service.ProjectService;
import com.unis.common.global.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/projects")
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/")
    public ResponseEntity<ApiResponse<?>> getProjects() {
        ArrayList<GetProjectsResponse> responses = projectService.getProjects();
        return (responses != null)?
            ResponseEntity.ok(ApiResponse.success(responses)):
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.error(500, "프로젝트를 불러오는 데 실패했습니다."));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<?>> postProject(@RequestBody @Valid PostProjectRequest request) {
        PostProjectResponse response = projectService.postProject(request);
        return (response != null)?
            ResponseEntity.ok(ApiResponse.created(response)):
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.error(500, "프로젝트 생성에 실패했습니다."));
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ApiResponse<?>> getProject(@PathVariable("projectId") Integer projectId) {
        GetProjectResponse response = projectService.getProject(projectId);
        return (response != null)?
            ResponseEntity.ok(ApiResponse.success(response)):
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.error(500, "프로젝트 불러오기에 실패했습니다."));
    }

    @PutMapping("/{projectId}/update")
    public ResponseEntity<ApiResponse<?>> putProject(@PathVariable("projectId") Integer projectId,
                                                     @RequestBody PutProjectRequest request) {
        PutProjectResponse response = projectService.putProject(projectId, request);
        return (response != null)?
            ResponseEntity.ok(ApiResponse.success(response)):
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.error(500, "프로젝트 수정에 실패했습니다."));
    }

    @DeleteMapping("/{projectId}/delete")
    public ResponseEntity<ApiResponse<?>> deleteProject(@PathVariable("projectId") Integer projectId) {
        DeleteProjectResponse response = projectService.deleteProject(projectId);
        return (response != null)?
            ResponseEntity.ok(ApiResponse.success(response)):
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.error(500, "프로젝트 삭제에 실패했습니다."));
    }
}
