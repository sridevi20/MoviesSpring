package com.example.codeclan.movies.Movies.repositories;

import com.example.codeclan.movies.Movies.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> findFilmByDirectorId(Long l);
}
