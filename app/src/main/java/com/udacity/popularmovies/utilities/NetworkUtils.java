/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.udacity.popularmovies.utilities;

import android.net.Uri;

import com.udacity.popularmovies.BuildConfig;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * These utilities will be used to communicate with the network.
 */
public class NetworkUtils {
    //http://api.themoviedb.org/4/discover/movie?sort_by=popularity.desc&api_key=8778f67f11a5a1dcb6ee731a56892416
//http://api.themoviedb.org/4/discover/movie?sort_by=vote_average.desc&api_key=8778f67f11a5a1dcb6ee731a56892416

    final static String MOVIES_DB_BASE_URL =
            "http://api.themoviedb.org/4/discover/movie";

    final static String API_KEY = "api_key";

    final static String PARAM_SORT = "sort_by";
    final static String sortByPopularity = "popularity.desc";
    final static String sortByRating = "vote_average.desc";


    public static URL buildUrl(String moviesSortQuery) {
        Uri builtUri = Uri.parse(MOVIES_DB_BASE_URL).buildUpon()
                .appendQueryParameter(API_KEY, BuildConfig.MOVIE_DB_API_KEY)
                .appendQueryParameter(PARAM_SORT, moviesSortQuery)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    /**
     * This method returns the entire result from the HTTP response.
     *
     * @param url The URL to fetch the HTTP response from.
     * @return The contents of the HTTP response.
     * @throws IOException Related to network and stream reading
     */
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}