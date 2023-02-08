package com.example.portfolio.repository;

import com.example.portfolio.model.FontColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FontColorRepository extends JpaRepository<FontColor, Long> {
}
