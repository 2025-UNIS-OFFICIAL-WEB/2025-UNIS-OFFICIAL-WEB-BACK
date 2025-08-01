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
public class PostProjectRequest {
    @NotBlank(message = "서비스 이름은 필수입니다.")
    private String serviceName;
    @NotBlank(message = "서비스 한 줄 소개는 필수입니다.")
    private String shortDescription;
    @NotBlank(message = "서비스 소개는 필수입니다.")
    private String description;
    private String githubUrl;
    private String instagramUrl;
    private String etcUrl;
    @NotNull(message = "기수는 필수입니다.")
    private Integer generation;
    @NotNull(message = "창업팀 여부는 필수입니다.")
    private Boolean isAlumni;
    @NotNull(message = "공식 프로젝트 여부는 필수입니다.")
    private Boolean isOfficial;
}
