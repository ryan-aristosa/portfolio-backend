package com.example.portfolio.repository;

import com.example.portfolio.model.ProjectStack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectStackRepository extends JpaRepository<ProjectStack, Long> {

    List<ProjectStack> findByProjectId(Long projectId);

}
