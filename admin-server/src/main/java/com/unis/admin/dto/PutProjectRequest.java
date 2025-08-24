package com.unis.admin.dto;

import com.unis.common.domain.Project;
import com.unis.common.domain.ProjectImage;
import com.unis.common.repository.ProjectImageRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PutProjectRequest {
    private final ProjectImageRepository projectImageRepository;

    private ArrayList<String> imageUrls;
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

    public void applyTo(Project project, List<String> imageUrls) {
        if (imageUrls != null) {
            projectImageRepository.deleteAllByProject(project);
            for (String imageUrl : imageUrls) {
                ProjectImage projectImage = ProjectImage.builder()
                    .id(null)
                    .project(project)
                    .url(imageUrl)
                    .build();
                projectImageRepository.save(projectImage);
            }
        }
        // 그 외 필드 업데이트
        project.setServiceName(this.serviceName);
        project.setShortDescription(this.shortDescription);
        project.setDescription(this.description);
        project.setGithubUrl(this.githubUrl);
        project.setInstagramUrl(this.instagramUrl);
        project.setEtcUrl(this.etcUrl);
        project.setGeneration(this.generation);
        project.setIsAlumni(this.isAlumni);
        project.setIsOfficial(this.isOfficial);
    }
}
