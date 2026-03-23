package org.example.webapplab1.movies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;
import java.time.LocalDate;
import java.util.List;

public interface MovieRepo extends ListCrudRepository<Movie,Long> {

    Page <Movie> findByTitleContainingIgnoreCaseAndDirectorContainingIgnoreCaseAndReleaseDate(
            String title, String director, LocalDate releaseDate, Pageable pageable);

    Page<Movie> findByTitleContainingIgnoreCaseAndDirectorContainingIgnoreCase(String title, String director, Pageable pageable);

    Page<Movie> findAll(Pageable pageable);

    List<Movie> findByTitleContainingIgnoreCase(String title);




}
