package org.example.webapplab1.movies;

import jakarta.validation.Valid;
import org.example.webapplab1.dto.CreateMovieDTO;
import org.example.webapplab1.dto.MovieDTO;
import org.example.webapplab1.dto.UpdateMovieDTO;
import org.example.webapplab1.mapper.MovieMapper;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;


@Controller
public class MovieController {

    private final MovieService movieService;
    private final MovieMapper movieMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @GetMapping("/movies/new")
    public String showCreateForm(Model model) {
        model.addAttribute("movie", new CreateMovieDTO());
        return "create-movie";
    }

    @PostMapping("/movies")
    public String createMovie(@Valid @ModelAttribute("movie") CreateMovieDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            return "create-movie";
        }
        movieService.createMovie(dto);
        return "redirect:/movies";
    }

    @PostMapping("/movies/{id}/delete")
    public String deleteMovie(@PathVariable("id") Long id) {
        movieService.deleteById(id);
        return "redirect:/movies";
    }

    @GetMapping("/movies/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Movie movie = movieService.findById(id);
        model.addAttribute("movie", movieMapper.toUpdateDTO(movie));
        return "edit-movie";
    }
    @PostMapping("/movies/update/{id}")
    public String updateMovie(@PathVariable("id") Long id,
                              @Valid @ModelAttribute("movie") UpdateMovieDTO dto,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "edit-movie";
        }
        movieService.updateMovie(id,dto);
        return "redirect:/movies";
    }
    @GetMapping("/movies")
    public String listMovies (@RequestParam(required = false) String title,
                              @RequestParam(required = false) String director,
                              @RequestParam(required = false) @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate releaseDate,
                              @RequestParam(defaultValue = "0")int page,
                              Model model) {

        Page<MovieDTO> moviePage = movieService.filterMovies(title, director, releaseDate, page, 10);

        model.addAttribute("movies", moviePage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", moviePage.getTotalPages());
        model.addAttribute("title", title);
        model.addAttribute("director", director);
        model.addAttribute("releaseDate", releaseDate);

        return "movies";
    }
}

