package org.example.webapplab1.movies;

import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface MovieRepo extends ListCrudRepository<Movie,Long> {
    List<Movie> findByTitleContainingIgnoreCase(String title);

    List<Movie> findByReleaseDate(LocalDate releaseDate);
    List<Movie> findByDirectorContainingIgnoreCase(String director);
}
