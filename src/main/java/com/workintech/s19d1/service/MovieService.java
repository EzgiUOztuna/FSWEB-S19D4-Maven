package com.workintech.s19d1.service;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie find(long id);
    Movie save(Movie movie, Actor actor);
    Movie update(long id,Movie updatedMovie);
    Movie delete(long id);
}
