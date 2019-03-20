package com.tasks.android.yamsafertask;

import Models.GenresClass;
import Models.Movie;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by asus on 1/28/2019.
 */

public interface APIInterface {

    String DISCOVER_MOVIES  = "discover/movie?&api_key=bb086102499d3c4b2a86ab4d649ad6d7";
    String GENRE_LIST = "genre/movie/list?api_key=7f8feac9c848bbf3ba5b99ebeac12f20&language=en-US";
    //String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500";


    @GET(DISCOVER_MOVIES)
    Call<Movie> getDiscoverMovies();

    @GET(GENRE_LIST)
    Call<GenresClass> getMoviesGenre();


}
