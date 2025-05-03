package com.modernjava.latestfeatures.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class MoviesClient {
	
	private HttpClient client = HttpClient.newBuilder()
			.connectTimeout(Duration.ofSeconds(2))
			.build();
	
	private final ObjectMapper objMapper = new ObjectMapper()
			.registerModule(new JavaTimeModule())
			.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    public static String ALL_MOVIES_URL = "http://127.0.0.1:8000/src/main/resources/movies.json";
    public static String MOVIE_BY_ID_URL = "http://127.0.0.1:8000/src/main/resources/movie_by_id.json";

    public Movie getMovieById() {
    	
    	var request = requestBuilder(MOVIE_BY_ID_URL);
    	 try {
			var response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println("Status code as : " + response.statusCode());
			return objMapper.readValue(response.body(), Movie.class);
		} catch (Exception e) {
			System.err.println(e);
			throw new RuntimeException(e);
		}
    }
    
    public CompletableFuture<Movie> getMovieByIdAsync() {
    	
    	var request = requestBuilder(MOVIE_BY_ID_URL);
    	 try {
			var response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
			
			return response.thenApply(httpResponse -> {
				System.out.println("Status code as : " + httpResponse.statusCode());
				try {
					return objMapper.readValue(httpResponse.body(), Movie.class);
				} catch (Exception e) {
					System.err.println(e);
					throw new RuntimeException(e);
				}
			});
			
    	 } catch (Exception e) {
				System.err.println(e);
				throw new RuntimeException(e);
		}
    }
    
    public List<Movie> getAllMovies() {
    	
    	var request = requestBuilder(ALL_MOVIES_URL);
    	 try {
			var response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println("Status code as : " + response.statusCode());
			return objMapper.readValue(response.body(), new TypeReference<>() {
			});
		} catch (Exception e) {
			System.err.println(e);
			throw new RuntimeException(e);
		}
    }
    
    public static HttpRequest requestBuilder(String url) {
    	return HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
    }

}
