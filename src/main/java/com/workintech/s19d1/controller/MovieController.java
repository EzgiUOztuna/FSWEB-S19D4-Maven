package com.workintech.s19d1.controller;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/movie")
public class MovieController {
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAll(){
       List<Movie> movieList = movieService.findAll();

       return movieList.stream().map(movie -> {movie.setActors(movie.getActors()); return movie;
       }).collect(Collectors.toList());
    }
/*
    @GetMapping("/{id}")
    public Movie getById(@PathVariable long id){
        return movieService.findById(id);
    }

    @PostMapping
    public Movie save(@RequestBody MovieActorRequest request){
        return movieService.save(request.getMovies(), request.getActor());
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
    }*/
}
