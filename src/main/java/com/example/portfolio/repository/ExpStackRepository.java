package com.example.portfolio.repository;

import com.example.portfolio.model.ExpStack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpStackRepository extends JpaRepository<ExpStack, Long> {

    List<ExpStack> findByExperienceId(Long experienceId);

}
