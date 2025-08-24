package com.unis.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetProjectResponse {
    private ArrayList<String> imageUrls;
    private String serviceName;
    private String shortDescription;
    private String description;
    private String githubUrl;
    private String instagramUrl;
    private String etcUrl;
    private Integer generation;
    private Boolean isAlumni;
    private Boolean isOfficial;
}
