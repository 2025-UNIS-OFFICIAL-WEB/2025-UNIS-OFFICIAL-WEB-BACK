package com.unis.common.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "project")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Integer projectId;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "service_name", nullable = false, length = 100)
    private String serviceName;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    @Column(name = "github_url")
    private String githubUrl;

    @Column(name = "instagram_url")
    private String instagramUrl;

    @Column(name = "generation", nullable = false)
    private Integer generation;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;
}
