package com.unis.admin.controller;

import com.unis.admin.dto.PostIsAvailableResponse;
import com.unis.admin.dto.PutApplyLinkRequest;
import com.unis.admin.dto.PutApplyLinkResponse;
import com.unis.admin.service.ApplyService;
import com.unis.common.global.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/apply")
public class ApplyController {
    private final ApplyService applyService;

    @PutMapping("/link")
    public ResponseEntity<ApiResponse<?>> putApplyLink(@RequestBody @Valid PutApplyLinkRequest request) {
        PutApplyLinkResponse response = applyService.putApplyLink(request);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @PostMapping("/available")
    public ResponseEntity<ApiResponse<?>> postIsAvailable() {
        PostIsAvailableResponse response = applyService.postIsAvailable();
        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
