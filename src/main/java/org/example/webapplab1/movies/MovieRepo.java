package org.example.webapplab1.movies;

import org.springframework.data.repository.ListCrudRepository;

public interface MovieRepo extends ListCrudRepository<Movie,Long> {
    Long id(Long id);
}
