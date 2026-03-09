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
}
