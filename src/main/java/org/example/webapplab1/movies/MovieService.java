package org.example.webapplab1.movies;
import org.example.webapplab1.ResourceNotFoundException;
import org.example.webapplab1.dto.CreateMovieDTO;
import org.example.webapplab1.dto.MovieDTO;
import org.example.webapplab1.dto.UpdateMovieDTO;
import org.example.webapplab1.mapper.MovieMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepo movieRepo;
    private final MovieMapper movieMapper;

    public MovieService(MovieRepo movieRepo, MovieMapper movieMapper) {
        this.movieRepo = movieRepo;
        this.movieMapper = movieMapper;
    }

    public Page<MovieDTO> getMovies(int page, int size) {
        Pageable pageable = PageRequest.of(Math.max(page, 0), Math.max(size, 1));
        return movieRepo.findAll(pageable)
            .map(movieMapper::toDTO);
    }

    public void createMovie(CreateMovieDTO dto) {
        Movie movie = movieMapper.toEntity(dto);
        movieRepo.save(movie);
    }

    public void updateMovie(Long id, UpdateMovieDTO dto) {
        Movie movie = findById(id);
        movieMapper.updateEntity(dto, movie);
        movieRepo.save(movie);
    }


    public void deleteById(Long id) {
        if (!movieRepo.existsById(id)) {
            throw new ResourceNotFoundException("Movie not found with id " + id);
        }
        movieRepo.deleteById(id);
    }

    public Movie findById(Long id) {
        return movieRepo.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));
    }
    public List<Movie> findByTitle(String title) {
        return movieRepo.findByTitleContainingIgnoreCase(title);
    }

    public Page <MovieDTO> filterMovies(String title, String director, LocalDate releaseDate, int page, int size) {
        Pageable pageable = PageRequest.of(Math.max(page, 0), Math.max(size, 1));

        String searchTitle = title == null ? "" : title.toLowerCase();
        String searchDirector = director == null ? "" : director.toLowerCase();

        Page <Movie> moviesPage;

        if (releaseDate == null) {
            moviesPage = movieRepo.findByTitleContainingIgnoreCaseAndDirectorContainingIgnoreCase(
                    searchTitle,
                    searchDirector,
                    pageable
            );
        } else {
            moviesPage = movieRepo.findByTitleContainingIgnoreCaseAndDirectorContainingIgnoreCaseAndReleaseDate(
                    searchTitle,
                    searchDirector,
                    releaseDate,
                    pageable
            );
        }
        return moviesPage.map(movieMapper::toDTO);
    }
}
