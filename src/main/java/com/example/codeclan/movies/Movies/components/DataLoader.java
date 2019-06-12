package com.example.codeclan.movies.Movies.components;

import com.example.codeclan.movies.Movies.models.Actor;
import com.example.codeclan.movies.Movies.models.Director;
import com.example.codeclan.movies.Movies.models.Film;
import com.example.codeclan.movies.Movies.models.GenreType;
import com.example.codeclan.movies.Movies.repositories.ActorRepository;
import com.example.codeclan.movies.Movies.repositories.DirectorRepository;
import com.example.codeclan.movies.Movies.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    DirectorRepository directorRepository;

    @Autowired
    ActorRepository actorRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args){
        Director director = new Director("Phyllida Lloyd");
        directorRepository.save(director);
        Director director1 = new Director("Chris Buck");
        directorRepository.save(director1);

        Film film1 = new Film("Iron Lady",director,GenreType.DRAMA);
        filmRepository.save(film1);
        Film film2 = new Film("MAMMA MIA",director,GenreType.COMEDY);
        filmRepository.save(film2);
        Film film3 = new Film("Gloriana",director,GenreType.HISTORICAL);
        filmRepository.save(film3);


        Actor actor1 = new Actor("MerylStreep ");
        actorRepository.save(actor1);
        Actor actor2 = new Actor(" Anna");
        actorRepository.save(actor2);
        Actor actor3 = new Actor("Julia Roberts");
        actorRepository.save(actor3);

        actor1.addFilm(film1);
        actor1.addFilm(film2);
        actorRepository.save(actor1);

        film1.addActor(actor1);
        film1.addActor(actor2);
        filmRepository.save(film1);




    }
}
