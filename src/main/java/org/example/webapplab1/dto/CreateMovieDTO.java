package org.example.webapplab1.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CreateMovieDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    private LocalDate releaseDate;

    @NotBlank
    private String director;

    @NotNull
    @Min(1)
    private Integer durationMinutes;

    public String getTitle() {
        return title;
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

    public void setTitle(String title) {
        this.title = title;
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
}
