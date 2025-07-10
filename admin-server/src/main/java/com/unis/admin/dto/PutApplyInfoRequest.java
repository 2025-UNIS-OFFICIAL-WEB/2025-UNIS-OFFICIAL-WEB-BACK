package com.unis.admin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PutApplyInfoRequest {
    @NotNull(message = "지원 가능 여부는 필수입니다.")
    private Boolean isAvailable;
    @NotBlank(message = "지원 링크는 필수입니다.")
    private String applyUrl;
}
