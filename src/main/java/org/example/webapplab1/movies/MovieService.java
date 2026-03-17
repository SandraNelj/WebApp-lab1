package org.example.webapplab1.movies;
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
        String searchTitle = title == null ? "" : title.toLowerCase();
        String searchDirector = director == null ? "" : director.toLowerCase();

        if (releaseDate == null) {
            return movieRepo.findAll().stream()
                    .filter(m -> m.getTitle() != null && m.getTitle().toLowerCase().contains(searchTitle))
                    .filter(m -> m.getDirector() != null && m.getDirector().toLowerCase().contains(searchDirector))
                    .toList();
        }

        return movieRepo.findByTitleContainingIgnoreCaseAndDirectorContainingIgnoreCaseAndReleaseDate(
                title == null ? "" : title,
                director == null ? "" : director,
                releaseDate
        );
    }
}
