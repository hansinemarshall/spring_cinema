package com.bnta.spring_cinema.controllers;

import com.bnta.spring_cinema.models.Movie;
import com.bnta.spring_cinema.models.Reply;
import com.bnta.spring_cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/movies")
public class MovieController {

    private Movie movie;

    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<Reply> addMovie(@RequestBody Movie movie){
        Reply reply = movieService.addNewMovie(movie);
        return new ResponseEntity<>(reply, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id){
        Movie movie = movieService.getMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @DeleteMapping (value = "/delete/{id}")
    public ResponseEntity removeMovie(@PathVariable int id){
        movieService.removeMovie(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PatchMapping (value = "/update/{id}")
    public ResponseEntity<Reply> updateMovie(@RequestBody String title, @PathVariable int id){
        Reply reply = movieService.updateMovieTitle(id, title);
        return new ResponseEntity<>(reply, HttpStatus.CREATED);
    }




}
