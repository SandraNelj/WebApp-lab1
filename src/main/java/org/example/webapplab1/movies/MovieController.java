package org.example.webapplab1.movies;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public String getMovies(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        System.out.println("Found " + movies.size() + " movies");
    model.addAttribute("movies", movies);
    return "movies";
    }
}
