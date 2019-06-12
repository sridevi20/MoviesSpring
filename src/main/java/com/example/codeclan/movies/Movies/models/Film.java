package com.example.codeclan.movies.Movies.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "films")


public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @JsonIgnoreProperties("films")

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private Director director;

    @Column(name = "genreType")
    @Enumerated(value = EnumType.STRING)
    private GenreType genreType;

    @ManyToMany
    @JoinTable(
            name = "films_actors",
            joinColumns = { @JoinColumn(
                    name = "film_id",
                    nullable = false,
                    updatable = false)
            },
            inverseJoinColumns = { @JoinColumn(
                    name = "actor_id",
                    nullable = false,
                    updatable = false)
            })

    private List<Actor> actors;

    public Film(String title, Director director, GenreType genreType) {
        this.title = title;
        this.director = director;
        this.genreType = genreType;
        this.actors = new ArrayList<>();

    }

    public Film() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public GenreType getGenreType() {
        return genreType;
    }

    public void setGenreType(GenreType genreType) {
        this.genreType = genreType;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void addActor(Actor actor){
        this.actors.add(actor);

    }
}
