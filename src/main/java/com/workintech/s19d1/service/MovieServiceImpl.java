package com.workintech.s19d1.service;

import com.workintech.s19d1.dao.ActorDao;
import com.workintech.s19d1.dao.MovieDao;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{
    private MovieDao movieDao;
    private ActorDao actorDao;

    @Autowired
    public MovieServiceImpl(ActorDao actorDao, MovieDao movieDao) {
        this.actorDao = actorDao;
        this.movieDao = movieDao;
    }

    @Override
    public List<Movie> findAll() {
        return movieDao.findAll();
    }

    @Override
    public Movie find(long id) {
        return movieDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Movie save(Movie movie, Actor actor) {
        // Actor'ın daha önce eklenip eklenmediğini kontrol ederiz
        Actor existingActor = actorDao.findByName(actor.getFirstName(), actor.getLastName()).orElse(null);
        if(existingActor == null){
            existingActor= actorDao.save(actor);
        }

        // Movie'nin daha önce eklenip eklenmediğini kontrol ederiz
        Movie existingMovie = movieDao.findByName(movie.getName()).orElse(null);
        if(existingMovie == null){
            existingMovie=movieDao.save(movie);
        }

        // İlişkiyi kurarız.
        existingMovie.getActors().add(existingActor);
        existingActor.getMovies().add(existingMovie);

        // Güncellenmiş ilişkileri kaydederiz.
        return movieDao.save(existingMovie);
    }

    @Override
    @Transactional
    public Movie update(long id, Movie updatedMovie) {
        Movie existingMovie = movieDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Movie with ID "+ id + " not found") );

        existingMovie.setName(updatedMovie.getName());
        existingMovie.setDirectorName(updatedMovie.getDirectorName());
        existingMovie.setRating(updatedMovie.getRating());
        existingMovie.setReleaseDate(updatedMovie.getReleaseDate());
        existingMovie.setActors(updatedMovie.getActors());

        return movieDao.save(existingMovie);
    }

    @Override
    @Transactional
    public Movie delete(long id) {
        Movie deletedMovie = find(id);
        movieDao.delete(deletedMovie);
        return deletedMovie;
    }
}
