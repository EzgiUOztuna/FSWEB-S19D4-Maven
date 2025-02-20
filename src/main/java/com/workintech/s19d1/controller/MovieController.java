package com.workintech.s19d1.controller;

import com.workintech.s19d1.dto.MovieActorRequest;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.MovieService;
import com.workintech.s19d1.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAll(){
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public Movie getById(@PathVariable long id){
        return movieService.find(id);
    }

    @PostMapping("/")
    public Movie save(@RequestBody MovieActorRequest request){
        Movie savedMovie = movieService.save(request.movie(), request.actor());
        return savedMovie;
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable long id, @RequestBody Movie updatedMovie){
        Movie savedMovie = movieService.update(id, updatedMovie);
        return savedMovie;
    }

    @DeleteMapping("/{id}")
    public Movie delete(@PathVariable long id){
        Movie deletedMovie = movieService.delete(id);
        return deletedMovie;
    }
}
