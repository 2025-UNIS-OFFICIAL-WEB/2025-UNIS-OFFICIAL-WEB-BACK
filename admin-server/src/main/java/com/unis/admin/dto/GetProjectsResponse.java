package com.unis.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetProjectsResponse {
    private Integer projectId;
    private String serviceName;
    private Integer generation;
    private String shortDescription;
}
