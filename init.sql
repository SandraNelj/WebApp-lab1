CREATE TABLE movies (
id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    release_date DATE,
    director VARCHAR(255),
    duration_minutes INT
);

INSERT INTO movies (title, description, release_date, director, duration_minutes)
VALUES
    ('The Shawshank Redemption', 'Two imprisoned men bond over years, finding hope and redemption.', '1994-09-23', 'Frank Darabont', 142),
    ('The Godfather', 'The aging patriarch of an organized crime dynasty transfers control to his reluctant son.', '1972-03-24', 'Francis Ford Coppola', 175),
    ('The Dark Knight', 'Batman faces the Joker, a criminal mastermind spreading chaos in Gotham.', '2008-07-18', 'Christopher Nolan', 152),
    ('Pulp Fiction', 'The lives of criminals intertwine in a series of violent and darkly comedic stories.', '1994-10-14', 'Quentin Tarantino', 154),
    ('Forrest Gump', 'A kind-hearted man witnesses and influences several historical events.', '1994-07-06', 'Robert Zemeckis', 142),
    ('Inception', 'A thief steals secrets by entering people’s dreams.', '2010-07-16', 'Christopher Nolan', 148),
    ('Fight Club', 'An insomniac office worker forms an underground fight club.', '1999-10-15', 'David Fincher', 139),
    ('The Matrix', 'A hacker discovers reality is a simulated world controlled by machines.', '1999-03-31', 'The Wachowskis', 136),
    ('Goodfellas', 'The rise and fall of mob associate Henry Hill.', '1990-09-19', 'Martin Scorsese', 146),
    ('The Lord of the Rings: The Fellowship of the Ring', 'A hobbit begins a quest to destroy a powerful ring.', '2001-12-19', 'Peter Jackson', 178),
    ('The Lord of the Rings: The Two Towers', 'The fellowship is broken but the quest continues.', '2002-12-18', 'Peter Jackson', 179),
    ('The Lord of the Rings: The Return of the King', 'The final battle for Middle-earth begins.', '2003-12-17', 'Peter Jackson', 201),
    ('Interstellar', 'Explorers travel through a wormhole in space to save humanity.', '2014-11-07', 'Christopher Nolan', 169),
    ('Gladiator', 'A Roman general seeks revenge against a corrupt emperor.', '2000-05-05', 'Ridley Scott', 155),
    ('Titanic', 'A romance unfolds aboard the ill-fated RMS Titanic.', '1997-12-19', 'James Cameron', 195),
    ('Jurassic Park', 'Scientists clone dinosaurs and create a theme park that goes wrong.', '1993-06-11', 'Steven Spielberg', 127),
    ('The Lion King', 'A young lion prince flees his kingdom after his father’s death.', '1994-06-24', 'Roger Allers & Rob Minkoff', 88),
    ('Avatar', 'A marine on an alien planet becomes torn between two worlds.', '2009-12-18', 'James Cameron', 162),
    ('The Avengers', 'Earth’s mightiest heroes unite to stop an alien invasion.', '2012-05-04', 'Joss Whedon', 143),
    ('Spider-Man: No Way Home', 'Spider-Man faces villains from other universes.', '2021-12-17', 'Jon Watts', 148);


select * from movies
