package com.udacity.popularmovies;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.udacity.popularmovies.model.DiscoverMoviesResponse;
import com.udacity.popularmovies.model.MovieMetadata;
import com.udacity.popularmovies.utilities.NetworkUtils;

import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieImageGridAdapter.MovieImageGridOnClickHandler {

    static
    {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    private static final int NUM_OF_COL = 2;
    private RecyclerView mRecyclerView;
    private MovieImageGridAdapter mMovieImageGridAdapter;

    private TextView mErrorMessageDisplay;

    private ProgressBar mLoadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mErrorMessageDisplay = findViewById(R.id.tv_error_message_display);
        mLoadingIndicator = findViewById(R.id.pb_loading_indicator);

        mRecyclerView = findViewById(R.id.movies_recyclerview);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, NUM_OF_COL));
        //StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        //mRecyclerView.setLayoutManager(sglm);
        mRecyclerView.addItemDecoration(new GridItemDecoration(10, 2));
        mMovieImageGridAdapter = new MovieImageGridAdapter(this, this);
        mRecyclerView.setAdapter(mMovieImageGridAdapter);

        loadMoviesData();

        //http://api.themoviedb.org/3/movie/popular?language=en-US&api_key=8778f67f11a5a1dcb6ee731a56892416
        //http://api.themoviedb.org/3/movie/popular?language=en-US&api_key=8778f67f11a5a1dcb6ee731a56892416


        //https://image.tmdb.org/t/p/w185/nUXCJMnAiwCpNPZuJH2n6h5hGtF.jpg


    }

    private void loadMoviesData() {
        showWMoviesDataView();
        //String sortByCondition = "popularity"; //"vote_average"// //SunshinePreferences.getPreferredWeatherLocation(this);
        new FetchMoviesTask().execute(NetworkUtils.POPULARITY);
    }

    @Override
    public void onClick(MovieMetadata movieMetadata) {
        long id = movieMetadata.getId();
        Toast.makeText(MainActivity.this, "ID = " + id , Toast.LENGTH_SHORT).show();
        launchDetailActivity(movieMetadata);
    }

    private void showWMoviesDataView() {
        /* First, make sure the error is invisible */
        mErrorMessageDisplay.setVisibility(View.INVISIBLE);
        /* Then, make sure the weather data is visible */
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void showErrorMessage() {
        /* First, hide the currently visible data */
        mRecyclerView.setVisibility(View.INVISIBLE);
        /* Then, show the error */
        mErrorMessageDisplay.setVisibility(View.VISIBLE);
    }

    private void launchDetailActivity(MovieMetadata movieMetadata) {
        Context context = MainActivity.this;
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(DetailActivity.MOVIE_DETAILS, movieMetadata);
        context.startActivity(intent);
    }

    private class FetchMoviesTask extends AsyncTask<String, Void, List<MovieMetadata>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mLoadingIndicator.setVisibility(View.VISIBLE);
        }

        @Override
        protected List<MovieMetadata> doInBackground(String... params) {

            if (params.length == 0) {
                return null;
            }

            String sortByCondition = params[0];
            URL moviesRequestUrl = NetworkUtils.buildUrl(sortByCondition, 1);

            try {
                String jsonMoviesResponse = NetworkUtils.getResponseFromHttpUrl(moviesRequestUrl);
                Gson gson = new Gson();
                DiscoverMoviesResponse discoverMoviesResponse = gson.fromJson(jsonMoviesResponse, DiscoverMoviesResponse.class);
                return discoverMoviesResponse.getResults();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<MovieMetadata> moviesData) {
            mLoadingIndicator.setVisibility(View.INVISIBLE);
            if (moviesData != null) {
                showWMoviesDataView();
                mMovieImageGridAdapter.setMoviesData(moviesData);
            } else {
                showErrorMessage();
            }
        }
    }
}
