package org.example.webapplab1;

import org.example.webapplab1.dto.MovieDTO;
import org.example.webapplab1.mapper.MovieMapper;
import org.example.webapplab1.movies.Movie;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieMapperTest {

    private MovieMapper movieMapper =  new MovieMapper();

    @Test
    void shouldMapToDTO() {
        Movie movie = new Movie(
            "Sandras movie",
            "A movie about something",
            LocalDate.now(),
            "Sandra",
            120);

        MovieDTO dto = movieMapper.toDTO(movie);
        assertEquals("Sandras movie", dto.getTitle());
    }
}
