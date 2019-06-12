package com.example.codeclan.movies.Movies.repositories;

import com.example.codeclan.movies.Movies.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository  extends JpaRepository<Director, Long> {
}
