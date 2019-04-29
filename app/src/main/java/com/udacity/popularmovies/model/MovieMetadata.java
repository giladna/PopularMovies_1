package com.udacity.popularmovies.model;

import android.text.TextUtils;

import java.util.List;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieMetadata {

    private static final String POSTER_URL_PREFIX = "https://image.tmdb.org/t/p/w185";
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("video")
    @Expose
    private Boolean video;
    @SerializedName("vote_count")
    @Expose
    private Long voteCount;
    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;
    @SerializedName("original_title")
    @Expose
    private String originalTitle;
    @SerializedName("genre_ids")
    @Expose
    private List<Long> genreIds = null;
    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @SerializedName("adult")
    @Expose
    private Boolean adult;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("poster_path")
    @Expose
    private String posterPath;


    public Double getPopularity() {
        return popularity;
    }

    public Long getId() {
        return id;
    }

    public Boolean getVideo() {
        return video;
    }

    public Long getVoteCount() {
        return voteCount;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public List<Long> getGenreIds() {
        return genreIds;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public Boolean getAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getPosterFullPath() {
        if(TextUtils.isEmpty(posterPath)) {
            return null;
        }
        return POSTER_URL_PREFIX + posterPath;
    }

    public String getFallbackPosterFullPath() {
        if(TextUtils.isEmpty(posterPath)) {
            return null;
        }
        return POSTER_URL_PREFIX + getBackdropPath();
    }
}