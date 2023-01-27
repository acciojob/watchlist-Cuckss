package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie) {
        return movieRepository.addMovie(movie);
    }

    public String addDirector(Director director) {
        return movieRepository.addDirector(director);
    }

    public String addMovieDirectorPair(String moviename, String directorname) {
     return movieRepository.addMovieDirectorPair(moviename,directorname);
    }
    public Movie getMovieByName(String moviename){
        return movieRepository.getMovieByName(moviename);
    }
    public Director getDirectorByName(String directorname){
        return movieRepository.getDirectorByName(directorname);
    }
    public List getMoviesByDirectorName (String directorname){
        return movieRepository.getMoviesByDirectorName(directorname);
    }
    public List findAllMovies(){
       return movieRepository.findAllMovies();
    }
    public String deleteDirectorByName(String directorname){
      return  movieRepository.deleteDirectorByName(directorname);
    }
    public String deleteAllDirectors(){
  return movieRepository.deleteAllDirectors();
    }
}