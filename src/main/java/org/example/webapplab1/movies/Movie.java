package org.example.webapplab1.movies;

import jakarta.persistence.*;
import org.hibernate.proxy.HibernateProxy;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Column (name = "release_date")
    private LocalDate releaseDate;

    private String director;

    @Column (name = "duration_minutes")
    private Integer durationMinutes;

    public Movie() {}

    public Movie(String title, String description, LocalDate releaseDate, String director, Integer durationMinutes) {
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.director = director;
        this.durationMinutes = durationMinutes;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Movie movie = (Movie) o;
        return getId() != null && Objects.equals(getId(), movie.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
