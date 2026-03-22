package org.example.webapplab1;

import org.example.webapplab1.dto.CreateMovieDTO;
import org.example.webapplab1.dto.MovieDTO;
import org.example.webapplab1.dto.UpdateMovieDTO;
import org.example.webapplab1.mapper.MovieMapper;
import org.example.webapplab1.movies.Movie;
import org.example.webapplab1.movies.MovieRepo;
import org.example.webapplab1.movies.MovieService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {
    @Mock
    private MovieRepo movieRepo;

    @Mock
    private MovieMapper movieMapper;

    @InjectMocks
    private MovieService movieService;

    @Test
    @DisplayName("Should return a list of all movies")
    void shouldReturnAllMovies() {
        when(movieRepo.findAll()).thenReturn(List.of(new Movie()));
        List < MovieDTO> result = movieService.getAllMovies();
        assertNotNull(result);
    }

    @Test
    @DisplayName("Should successfully create a new movie")
    void createMovie() {
        CreateMovieDTO createMovieDTO = new CreateMovieDTO();
        createMovieDTO.setTitle("Sandras movie");
        createMovieDTO.setDescription("A movie about something");
        createMovieDTO.setReleaseDate(LocalDate.now());
        createMovieDTO.setDirector("Sandra");
        createMovieDTO.setDurationMinutes(120);

        Movie movie = new Movie();

        when(movieMapper.toEntity(createMovieDTO)).thenReturn(movie);
        movieService.createMovie(createMovieDTO);
        verify(movieRepo).save(movie);

    }

    @Test
    @DisplayName("Should successfully delete a movie if existing")
    void deleteMovie() {
        Long id =  1L;
        when(movieRepo.existsById(id)).thenReturn(true);
        movieService.deleteById(id);
        verify(movieRepo).deleteById(id);
    }

    @Test
    @DisplayName("Should throw exception if movie does not exist")
    void deleteMovieWhenMovieDoesNotExist() {
        Long id =  1L;
        when(movieRepo.existsById(id)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class,
                () -> movieService.deleteById(id));
    }

    @Test
    @DisplayName("Should update movie")
    void updateMovie() {
        Long id =  1L;

        UpdateMovieDTO updateMovieDTO = new UpdateMovieDTO();
        updateMovieDTO.setTitle("Updated movie");

        Movie movie = new Movie();

        when(movieRepo.findById(id)).thenReturn(Optional.of(movie));

        movieService.updateMovie(id, updateMovieDTO);

        verify(movieMapper).updateEntity(updateMovieDTO, movie);
        verify(movieRepo).save(movie);
    }

}
