package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
  @Autowired
    MovieService movieService;
@PostMapping("/movies/add-movie")
  public ResponseEntity addMovie(@RequestBody Movie movie) {
  String response=movieService.addMovie(movie);
  return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
  }
  @PostMapping("movies/add-director")
  public ResponseEntity addDirector(@RequestBody Director director) {
    String response= movieService.addDirector(director);
    return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
  }
  @PutMapping("movies/add-movie-director-pair")
  public ResponseEntity addMovieDirectorPair(@RequestParam("movie") String moviename, @RequestParam("director") String directorname) {
  String response=movieService.addMovieDirectorPair(moviename,directorname);
  return new ResponseEntity<>(response,HttpStatus.CREATED);
  }
  @GetMapping("movies/get-movie-by-name/{name}")
  public ResponseEntity getMovieByName(@PathVariable("name") String moviename){
  Movie response=movieService.getMovieByName(moviename);
  return new ResponseEntity<>(response,HttpStatus.FOUND);
  }
  @GetMapping("movies/get-director-by-name/{name}")
  public ResponseEntity getDirectorByName(@PathVariable("name") String directorname){
  Director response=movieService.getDirectorByName(directorname);
  return new ResponseEntity<>(response,HttpStatus.FOUND);
  }
@GetMapping("movies/get-movies-by-director-name/{director}")
  public ResponseEntity getMoviesByDirectorName (@PathVariable("director") String directorname){
  List<String> response=movieService.getMoviesByDirectorName(directorname);
  return new ResponseEntity<>(response,HttpStatus.FOUND);
  }
  @GetMapping("movies/get-all-movies")
  public ResponseEntity findAllMovies(){
  List<String>response=movieService.findAllMovies();
  return new ResponseEntity<>(response,HttpStatus.FOUND);
  }
  @DeleteMapping("movies/delete-director-by-name")
  public ResponseEntity deleteDirectorByName(@RequestParam("director") String directorname){
  String response=movieService.deleteDirectorByName(directorname);
  return new ResponseEntity<>(response,HttpStatus.GONE);
  }
  @DeleteMapping("movies/delete-all-directors")
  public ResponseEntity deleteAllDirectors(){
  String response=movieService.deleteAllDirectors();
  return new ResponseEntity<>(response,HttpStatus.GONE);
  }
}
