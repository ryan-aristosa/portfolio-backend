package com.example.portfolio.repository;

import com.example.portfolio.model.Navigation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NavigationRepository extends JpaRepository<Navigation, Long> {

    List<Navigation> findByOrderByIdAsc();

}
