package com.unis.admin.controller;

import com.unis.admin.dto.*;
import com.unis.admin.service.ProjectService;
import com.unis.admin.service.S3Service;
import com.unis.common.global.ApiResponse;
import com.unis.common.repository.ProjectRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/projects")
public class ProjectController {
    private final ProjectService projectService;
    private final S3Service s3Service;

    @GetMapping("")
    public ResponseEntity<ApiResponse<?>> getProjects() {
        ArrayList<GetProjectsResponse> responses = projectService.getProjects();
        return (responses != null)?
            ResponseEntity.ok(ApiResponse.success(responses)):
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.error(500, "프로젝트를 불러오는 데 실패했습니다."));
    }

    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<?>> postProject(@RequestPart("data") @Valid PostProjectRequest request,
                                                      @RequestPart("image") MultipartFile image) {
        String imageUrl = s3Service.upload(image);
        PostProjectResponse response = projectService.postProject(request, imageUrl);

        return (response != null)?
            ResponseEntity.ok(ApiResponse.created(response)):
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ApiResponse.error(500, "프로젝트 생성에 실패했습니다."));
    }
    @GetMapping("/{projectId}")
    public ResponseEntity<ApiResponse<?>> getProject(@PathVariable("projectId") Integer projectId) {
        GetProjectResponse response = projectService.getProject(projectId);
        return (response != null)?
            ResponseEntity.ok(ApiResponse.success(response)):
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.error(500, "프로젝트 불러오기에 실패했습니다."));
    }

    @PutMapping(value = "/{projectId}/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<?>> putProject(@PathVariable("projectId") Integer projectId,
                                                     @RequestPart("data") PutProjectRequest request,
                                                     @RequestPart(value = "image", required = false) MultipartFile image) {
        String imageUrl = null;
        if (image != null && !image.isEmpty()) {
            imageUrl = s3Service.upload(image);
        }
        projectService.putProject(projectId, request, imageUrl);
        return ResponseEntity.ok(ApiResponse.success(null));
    }

    @DeleteMapping("/{projectId}/delete")
    public ResponseEntity<ApiResponse<?>> deleteProject(@PathVariable("projectId") Integer projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.ok(ApiResponse.success(null));
    }
}
