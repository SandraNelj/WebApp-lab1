package org.example.webapplab1.movies;
import org.springframework.data.repository.ListCrudRepository;
import java.time.LocalDate;
import java.util.List;

public interface MovieRepo extends ListCrudRepository<Movie,Long> {

    List <Movie> findByTitleContainingIgnoreCaseAndDirectorContainingIgnoreCaseAndReleaseDate(
            String title, String director, LocalDate releaseDate);

    List<Movie> findByTitleContainingIgnoreCase(String title);

    List<Movie> findByDirectorContainingIgnoreCase(String director);

    List<Movie> findByReleaseDate(LocalDate releaseDate);

    List<Movie> findByTitleContainingIgnoreCaseAndDirectorContainingIgnoreCase(String title, String director);


}
