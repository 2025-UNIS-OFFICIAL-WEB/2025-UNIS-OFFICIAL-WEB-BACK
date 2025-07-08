package com.unis.common.repository;

import com.unis.common.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    ArrayList<Project> findByIsDeletedFalseOrderByGenerationDescProjectIdAsc();
}
