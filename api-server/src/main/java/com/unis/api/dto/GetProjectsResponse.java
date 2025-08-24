package com.unis.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetProjectsResponse {
    private Integer projectId;
    private ArrayList<String> imageUrls;
    private String serviceName;
    private String shortDescription;
    private Integer generation;
    private Boolean isAlumni;
    private Boolean isOfficial;
}
