package com.example.codeclan.movies.Movies.repositories;

import com.example.codeclan.movies.Movies.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
