package com.bnta.spring_cinema.services;

import com.bnta.spring_cinema.models.Movie;
import com.bnta.spring_cinema.models.Reply;
import com.bnta.spring_cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    private ArrayList<Movie> movies;

    public MovieService() {
        this.movies = new ArrayList<>();
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }
    public Movie getMovieById(int id){
        return movieRepository.findById(id).get();
    }



    public Reply addNewMovie(Movie inputMovie){
        Movie movie = new Movie(inputMovie.getTitle(), inputMovie.getRating(), inputMovie.getDuration());
        movieRepository.save(movie);
        return new Reply("New movie added");
    }

    public void removeMovie(int id){
        movieRepository.deleteById(id);
    }

    public Reply updateMovieTitle (int id, String newTitle){
        getMovieById(id).setTitle(newTitle);
        return new Reply("Movie updated");
    }




}
