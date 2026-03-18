package org.example.webapplab1.mapper;

import org.example.webapplab1.dto.CreateMovieDTO;
import org.example.webapplab1.dto.MovieDTO;
import org.example.webapplab1.dto.UpdateMovieDTO;
import org.example.webapplab1.movies.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public Movie toEntity(CreateMovieDTO dto) {
        return new Movie(
                dto.getTitle(),
                dto.getDescription(),
                dto.getReleaseDate(),
                dto.getDirector(),
                dto.getDurationMinutes()
        );
    }

    public MovieDTO toDTO(Movie movie) {
        MovieDTO dto = new MovieDTO();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setDescription(movie.getDescription());
        dto.setReleaseDate(movie.getReleaseDate());
        dto.setDirector(movie.getDirector());
        dto.setDurationMinutes(movie.getDurationMinutes());
        return dto;
    }

    public void updateEntity(UpdateMovieDTO dto, Movie movie) {
        movie.setTitle(dto.getTitle());
        movie.setDescription(dto.getDescription());
        movie.setReleaseDate(dto.getReleaseDate());
        movie.setDirector(dto.getDirector());
        movie.setDurationMinutes(dto.getDurationMinutes());
    }

    public UpdateMovieDTO toUpdateDTO(Movie movie) {
        UpdateMovieDTO dto = new UpdateMovieDTO();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setDescription(movie.getDescription());
        dto.setReleaseDate(movie.getReleaseDate());
        dto.setDirector(movie.getDirector());
        dto.setDurationMinutes(movie.getDurationMinutes());
        return dto;
    }
}
