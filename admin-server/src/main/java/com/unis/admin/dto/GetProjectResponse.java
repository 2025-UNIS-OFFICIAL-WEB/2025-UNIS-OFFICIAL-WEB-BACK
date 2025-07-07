package com.unis.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetProjectResponse {
    private String imageUrl;
    private String serviceName;
    private String shortDescription;
    private String description;
    private String githubUrl;
    private String instagramUrl;
    private Integer generation;
}
