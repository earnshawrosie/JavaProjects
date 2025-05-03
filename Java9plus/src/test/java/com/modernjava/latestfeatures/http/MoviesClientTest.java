package com.modernjava.latestfeatures.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.modernjava.latestfeatures.http.MoviesClient;

//@Disabled
public class MoviesClientTest {

    MoviesClient moviesClient = new MoviesClient();
    
    @Test
    public void getMovieById() {
    	var movie  = moviesClient.getMovieById();
    	assertNotNull(movie);
    	assertEquals("Batman Begins", movie.name());
    }
    
    @Test
    public void getMovieByIdAsync() {
    	var movie  = moviesClient.getMovieByIdAsync().join();
    	assertNotNull(movie);
    	assertEquals("Batman Begins", movie.name());
    }
    
    @Test
    public void getAllMovies() {
    	var movies  = moviesClient.getAllMovies();
    	assertNotNull(movies);
    	assertEquals(10, movies.size());
    }

}
