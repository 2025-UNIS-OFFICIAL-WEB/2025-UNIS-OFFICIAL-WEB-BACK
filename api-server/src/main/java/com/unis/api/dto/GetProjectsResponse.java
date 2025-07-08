package com.unis.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetProjectsResponse {
    private String imageUrl;
    private String serviceName;
    private String shortDescription;
}
