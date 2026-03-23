package org.example.webapplab1;

import org.example.webapplab1.dto.MovieDTO;
import org.example.webapplab1.mapper.MovieMapper;
import org.example.webapplab1.movies.MovieController;
import org.example.webapplab1.movies.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(MovieController.class)
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MovieService movieService;

    @MockitoBean
    private MovieMapper movieMapper;

    @Test
    void shouldReturnMoviePage() throws Exception {

        Page<MovieDTO> mockPage = new PageImpl<>(List.of(new MovieDTO()));

        when(movieService.filterMovies(any(), any(), any(), anyInt(), anyInt()))
        .thenReturn(mockPage);

        mockMvc.perform(get("/movies"))
                .andExpect(status().isOk())
                .andExpect(view().name("movies"));
    }
}
