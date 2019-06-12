package com.example.codeclan.movies.Movies;

import com.example.codeclan.movies.Movies.models.Actor;
import com.example.codeclan.movies.Movies.models.Director;
import com.example.codeclan.movies.Movies.models.Film;
import com.example.codeclan.movies.Movies.models.GenreType;
import com.example.codeclan.movies.Movies.repositories.ActorRepository;
import com.example.codeclan.movies.Movies.repositories.DirectorRepository;
import com.example.codeclan.movies.Movies.repositories.FilmRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MoviesApplicationTests {
	@Autowired
	FilmRepository filmRepository;
	@Autowired
	DirectorRepository directorRepository;

	@Autowired
	ActorRepository actorRepository;


	@Test
	public void contextLoads() {
	}

	@Test
	public void createFilmAndDirector() {
		Director director = new Director("Chris Buck");
		directorRepository.save(director);

		Film film1 = new Film("Iron Lady", director, GenreType.DRAMA);
		filmRepository.save(film1);
	}
     @Test
	public void addFilmAndActors() {
		Director director = new Director("Chris Buck");
		directorRepository.save(director);

		Film film1 = new Film("Iron Lady", director, GenreType.HISTORICAL);
		filmRepository.save(film1);

		Actor actor1 = new Actor("MerylStreep ");
		actorRepository.save(actor1);

        actor1.addFilm(film1);
        actorRepository.save(actor1);

        film1.addActor(actor1);
        filmRepository.save(film1);



	}
	@Test
	public void canFindFilmByDirector(){
		List<Film> results = filmRepository.findFilmByDirectorId(1L);
	}
}


