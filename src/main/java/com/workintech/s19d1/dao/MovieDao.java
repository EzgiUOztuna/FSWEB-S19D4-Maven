package com.workintech.s19d1.dao;
import com.workintech.s19d1.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieDao extends JpaRepository<Movie, Long> {
    Optional<Movie> findByName(String name);
}
