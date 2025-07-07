package com.unis.admin.service;

import com.unis.admin.dto.PutApplyInfoRequest;
import com.unis.common.domain.ApplySetting;
import com.unis.common.repository.ApplySettingRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplyService {
    private final ApplySettingRepository applySettingRepository;

    public void putApplyInfo(@Valid PutApplyInfoRequest request) {
        ApplySetting setting = applySettingRepository.findById(1).orElse(null);
        setting.setApplyUrl(request.getApplyUrl());
        setting.setIsAvailable(request.getIsAvailable());
        applySettingRepository.save(setting);
    }
}
