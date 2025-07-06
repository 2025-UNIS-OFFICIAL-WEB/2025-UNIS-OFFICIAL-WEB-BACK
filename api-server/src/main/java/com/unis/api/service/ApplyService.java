package com.unis.api.service;

import com.unis.api.dto.GetApplyInfoResponse;
import com.unis.common.repository.ApplySettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplyService {
    private final ApplySettingRepository applySettingRepository;

    public GetApplyInfoResponse getApplyInfo() {
        return null;
    }
}
