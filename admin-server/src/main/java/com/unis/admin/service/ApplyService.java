package com.unis.admin.service;

import com.unis.admin.dto.PostIsAvailableResponse;
import com.unis.admin.dto.PutApplyLinkRequest;
import com.unis.common.domain.ApplySetting;
import com.unis.common.repository.ApplySettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplyService {
    private final ApplySettingRepository applySettingRepository;

    public void putApplyLink(PutApplyLinkRequest request) {
        ApplySetting setting = applySettingRepository.findById(1).orElse(null);
        setting.setApplyUrl(request.getApplyUrl());
        applySettingRepository.save(setting);
    }

    public PostIsAvailableResponse postIsAvailable() {
        ApplySetting setting = applySettingRepository.findById(1).orElse(null);
        if (setting.getIsAvailable())
            setting.setIsAvailable(false);
        else
            setting.setIsAvailable(true);
        ApplySetting saved = applySettingRepository.save(setting);
        return new PostIsAvailableResponse(saved.getIsAvailable());
    }
}
