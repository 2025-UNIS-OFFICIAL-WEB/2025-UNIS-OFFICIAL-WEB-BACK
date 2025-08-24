package com.unis.common.repository;

import com.unis.common.domain.Project;
import com.unis.common.domain.ProjectImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProjectImageRepository extends JpaRepository<ProjectImage, Integer> {
    ArrayList<String> findAllByProject(Project project);

    void deleteAllByProject(Project project);
}
