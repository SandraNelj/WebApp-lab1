package org.example.webapplab1.movies;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@Controller
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies/new")
    public String showCreateForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "create-movie";
    }

    @PostMapping("/movies")
    public String createMovie(@ModelAttribute("movie") Movie movie) {
        movieService.save(movie);
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
        model.addAttribute("movie", movie);
        return "edit-movie";
    }
    @PostMapping("/movies/update/{id}")
    public String updateMovie(@PathVariable("id") Long id,
                              @ModelAttribute("movie") Movie movie) {
        movie.setId(id);
        movieService.save(movie);
        return "redirect:/movies";
    }
    @GetMapping("/movies")
    public String listMovies (@RequestParam(required = false) String title,
                              @RequestParam(required = false) String director,
                              @RequestParam(required = false) @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate releaseDate,
                              Model model) {
        List <Movie> movies = movieService.filterMovies(title, director, releaseDate);
        model.addAttribute("movies", movies);
        model.addAttribute("title", title);
        model.addAttribute("director", director);
        model.addAttribute("releaseDate", releaseDate);

        return "movies";
    }
}

