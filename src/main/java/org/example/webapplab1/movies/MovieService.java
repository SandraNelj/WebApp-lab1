package org.example.webapplab1.movies;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepo movieRepo;

    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    public Movie save(Movie movie) {
        return movieRepo.save(movie);
    }

    public void deleteById(Long id) {
        movieRepo.deleteById(id);
    }

    public Movie findById(Long id) {
        return movieRepo.findById(id).get();
    }
}
