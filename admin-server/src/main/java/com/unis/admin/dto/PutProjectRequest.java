package com.unis.admin.dto;

import com.unis.common.domain.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PutProjectRequest {
    private String serviceName;
    private String shortDescription;
    private String description;
    private String githubUrl;
    private String instagramUrl;
    private String etcUrl;
    private Integer generation;

    public void applyTo(Project project, String imageUrl) {
        project.setImageUrl(imageUrl);
        project.setServiceName(this.serviceName);
        project.setShortDescription(this.shortDescription);
        project.setDescription(this.description);
        project.setGithubUrl(this.githubUrl);
        project.setInstagramUrl(this.instagramUrl);
        project.setGeneration(this.generation);
    }
}
