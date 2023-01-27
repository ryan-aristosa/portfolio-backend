package com.example.portfolio.repository;

import com.example.portfolio.model.ExpDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpDescriptionRepository extends JpaRepository<ExpDescription, Long> {

    List<ExpDescription> findByExperienceId(Long experienceId);

}
