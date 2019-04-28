package com.udacity.popularmovies.model;

import java.util.List;

public class MovieMetadata {

    private Integer voteCount;
    private Integer id;
    private Boolean video;

    private Double voteAverage;
    private String title;
    private Double popularity;
    private String posterPath;
    private String originalLanguage;
    private String originalTitle;
    private List<Integer> genreIds = null;
    private String backdropPath;
    private Boolean adult;
    private String overview;
    private String releaseDate;

    public Integer getVoteCount() {
        return voteCount;
    }
}