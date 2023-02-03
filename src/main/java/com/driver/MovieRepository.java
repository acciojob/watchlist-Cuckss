package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {
    Map<String,Movie> moviedb=new HashMap<>();
    Map<String,Director>directordb=new HashMap<>();
    Map<String, List<String>>pairdb=new HashMap<>();

    public String addMovie(Movie movie){
       String moviename=movie.getName();
       moviedb.put(moviename,movie);
       return "movie added successfully";
    }
    public String addDirector(Director director){
        String directorname=director.getName();
       directordb.put(directorname,director);
       return"director added successfully";
    }

    public String addMovieDirectorPair(String moviename,String directorname){

//       if(!pairdb.containsKey(directorname)){
//           pairdb.put(directorname,new ArrayList<>());
//           movielist.add(moviename);
           if(!pairdb.containsKey(directorname)){
               List<String>movielist=new ArrayList<>();
               movielist.add(moviename);
               pairdb.put(directorname,movielist);
           }else{
               pairdb.get(directorname).add(moviename);

       }
        return "Movie Added Successfully";
    }
     public Movie getMovieByName(String moviename){
        return moviedb.get(moviename);
     }

     public Director getDirectorByName(String directorname){
        return directordb.get(directorname);
     }

     public List  getMoviesByDirectorName (String directorname) {
//       return List.of(pairdb.get(directorname));
         List<String> movieList = new ArrayList<>();
         if (pairdb.containsKey(directorname)) {
             movieList = pairdb.get(directorname);

         }
         return movieList;
     }
     public List findAllMovies(){
        List<String>allmovies=new ArrayList<>();
        for(String str:moviedb.keySet()){
            allmovies.add(str);
        }
        return allmovies;
     }
     public String deleteDirectorByName(String directorname){
       if(!directordb.containsKey(directorname)){
           return"Invalid Request";
       }
       if(pairdb.containsKey(directorname)) {
           List<String> list = pairdb.get(directorname);
           for (String movie : list) {
               if (moviedb.containsKey(movie)) {
                   moviedb.remove(movie);
               }
           }
           pairdb.remove(directorname);
       }

        directordb.remove(directorname);
        return"Director removed successfully";
     }
      public String deleteAllDirectors(){

            for(String director: pairdb.keySet()){
                List<String>movies=pairdb.get(director);
                for(String movie:moviedb.keySet()){
                    if(movies.contains(movie)){
                        moviedb.remove(movie);
                    }
                }
                pairdb.remove(director);
            }
        directordb.clear();
            return "Removed all Director successfully";
      }

}
