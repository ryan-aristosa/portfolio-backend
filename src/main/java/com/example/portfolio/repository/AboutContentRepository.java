package com.example.portfolio.repository;

import com.example.portfolio.model.AboutContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AboutContentRepository extends JpaRepository<AboutContent, Long> {

    List<AboutContent> findByAboutId(Long aboutId);

}
