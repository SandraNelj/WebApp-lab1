package org.example.webapplab1;

import org.example.webapplab1.movies.Movie;
import org.example.webapplab1.movies.MovieRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private final MovieRepo movieRepo;

    public DataLoader(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        if (movieRepo.count() == 0) {
            movieRepo.saveAll(List.of(
                    new Movie("The Shawshank Redemption", "Two imprisoned men bond over years, finding hope and redemption.", LocalDate.of(1994, 9, 23), "Frank Darabont", 142),
                    new Movie("The Godfather", "The aging patriarch of an organized crime dynasty transfers control to his reluctant son.", LocalDate.of(1972, 3, 24), "Francis Ford Coppola", 175),
                    new Movie("The Dark Knight", "Batman faces the Joker, a criminal mastermind spreading chaos in Gotham.", LocalDate.of(2008, 7, 18), "Christopher Nolan", 152),
                    new Movie("Pulp Fiction", "The lives of criminals intertwine in a series of violent and darkly comedic stories.", LocalDate.of(1994, 10, 14), "Quentin Tarantino", 154),
                    new Movie("Forrest Gump", "A kind-hearted man witnesses and influences several historical events.", LocalDate.of(1994, 7, 6), "Robert Zemeckis", 142),
                    new Movie("Inception", "A thief steals secrets by entering people’s dreams.", LocalDate.of(2010, 7, 16), "Christopher Nolan", 148),
                    new Movie("Fight Club", "An insomniac office worker forms an underground fight club.", LocalDate.of(1999, 10, 15), "David Fincher", 139),
                    new Movie("The Matrix", "A hacker discovers reality is a simulated world controlled by machines.", LocalDate.of(1999, 3, 31), "The Wachowskis", 136),
                    new Movie("Goodfellas", "The rise and fall of mob associate Henry Hill.", LocalDate.of(1990, 9, 19), "Martin Scorsese", 146),
                    new Movie("The Lord of the Rings: The Fellowship of the Ring", "A hobbit begins a quest to destroy a powerful ring.", LocalDate.of(2001, 12, 19), "Peter Jackson", 178),
                    new Movie("The Lord of the Rings: The Two Towers", "The fellowship is broken but the quest continues.", LocalDate.of(2002, 12, 18), "Peter Jackson", 179),
                    new Movie("The Lord of the Rings: The Return of the King", "The final battle for Middle-earth begins.", LocalDate.of(2003, 12, 17), "Peter Jackson", 201),
                    new Movie("Interstellar", "Explorers travel through a wormhole in space to save humanity.", LocalDate.of(2014, 11, 7), "Christopher Nolan", 169),
                    new Movie("Gladiator", "A Roman general seeks revenge against a corrupt emperor.", LocalDate.of(2000, 5, 5), "Ridley Scott", 155),
                    new Movie("Titanic", "A romance unfolds aboard the ill-fated RMS Titanic.", LocalDate.of(1997, 12, 19), "James Cameron", 195),
                    new Movie("Jurassic Park", "Scientists clone dinosaurs and create a theme park that goes wrong.", LocalDate.of(1993, 6, 11), "Steven Spielberg", 127),
                    new Movie("The Lion King", "A young lion prince flees his kingdom after his father’s death.", LocalDate.of(1994, 6, 24), "Roger Allers & Rob Minkoff", 88),
                    new Movie("Avatar", "A marine on an alien planet becomes torn between two worlds.", LocalDate.of(2009, 12, 18), "James Cameron", 162),
                    new Movie("The Avengers", "Earth’s mightiest heroes unite to stop an alien invasion.", LocalDate.of(2012, 5, 4), "Joss Whedon", 143),
                    new Movie("Spider-Man: No Way Home", "Spider-Man faces villains from other universes.", LocalDate.of(2021, 12, 17), "Jon Watts", 148)
            ));
        }
    }
}
