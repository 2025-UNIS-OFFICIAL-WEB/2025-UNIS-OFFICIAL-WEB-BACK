package com.unis.admin.service;

import com.unis.admin.dto.PostIsAvailableResponse;
import com.unis.admin.dto.PutApplyLinkRequest;
import com.unis.admin.dto.PutApplyLinkResponse;
import com.unis.common.repository.ApplySettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplyService {
    private final ApplySettingRepository applySettingRepository;

    public PutApplyLinkResponse putApplyLink(PutApplyLinkRequest request) {
        return null;
    }

    public PostIsAvailableResponse postIsAvailable() {
        return null;
    }
}
