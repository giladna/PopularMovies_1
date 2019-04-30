package com.udacity.popularmovies.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import java.util.List;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieMetadata implements Parcelable {

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


    protected MovieMetadata(Parcel in) {
        if (in.readByte() == 0) {
            popularity = null;
        } else {
            popularity = in.readDouble();
        }
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        byte tmpVideo = in.readByte();
        video = tmpVideo == 0 ? null : tmpVideo == 1;
        if (in.readByte() == 0) {
            voteCount = null;
        } else {
            voteCount = in.readLong();
        }
        if (in.readByte() == 0) {
            voteAverage = null;
        } else {
            voteAverage = in.readDouble();
        }
        title = in.readString();
        releaseDate = in.readString();
        originalLanguage = in.readString();
        originalTitle = in.readString();
        backdropPath = in.readString();
        byte tmpAdult = in.readByte();
        adult = tmpAdult == 0 ? null : tmpAdult == 1;
        overview = in.readString();
        posterPath = in.readString();
    }

    public static final Creator<MovieMetadata> CREATOR = new Creator<MovieMetadata>() {
        @Override
        public MovieMetadata createFromParcel(Parcel in) {
            return new MovieMetadata(in);
        }

        @Override
        public MovieMetadata[] newArray(int size) {
            return new MovieMetadata[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (popularity == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(popularity);
        }
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        dest.writeByte((byte) (video == null ? 0 : video ? 1 : 2));
        if (voteCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(voteCount);
        }
        if (voteAverage == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(voteAverage);
        }
        dest.writeString(title);
        dest.writeString(releaseDate);
        dest.writeString(originalLanguage);
        dest.writeString(originalTitle);
        dest.writeString(backdropPath);
        dest.writeByte((byte) (adult == null ? 0 : adult ? 1 : 2));
        dest.writeString(overview);
        dest.writeString(posterPath);
    }
}