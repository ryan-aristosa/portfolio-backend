package com.example.portfolio.repository;

import com.example.portfolio.model.Footer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooterRepository extends JpaRepository<Footer, Long> {

    Footer findFirstByOrderByIdAsc();

}
