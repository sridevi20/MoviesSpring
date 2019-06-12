package com.example.codeclan.movies.Movies.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actors")


public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    @JsonIgnoreProperties("actors")

    @ManyToMany
    @JoinTable(
            name = "films_actors",
            joinColumns = { @JoinColumn(
            name = "actor_id",
            nullable = false,
            updatable = false)
    },
            inverseJoinColumns = { @JoinColumn(
                    name = "film_id",
                    nullable = false,
                    updatable = false)
            })

    private List<Film> films;

    public Actor(String name) {
        this.name = name;
        this.films = new ArrayList<>();
    }

    public Actor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void addFilm(Film film){
        this.films.add(film);
    }
}
