package org.example.webapplab1.movies;
import org.hibernate.query.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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
        return movieRepo.findById(id).
                orElseThrow(() -> new NoSuchElementException("Movie not found with id: " + id));
    }
    public List<Movie> findByTitle(String title) {
        return movieRepo.findByTitleContainingIgnoreCase(title);
    }
    public List <Movie> filterMovies(String title, String director, LocalDate releaseDate) {
        return movieRepo.findAll().stream()
                .filter(m-> title == null || m.getTitle().toLowerCase().contains(title.toLowerCase()))
                .filter(m-> director == null || m.getDirector().toLowerCase().contains(director.toLowerCase()))
                .filter(m-> releaseDate == null || m.getReleaseDate().isEqual(releaseDate))
                .collect(Collectors.toList());
    }
}
