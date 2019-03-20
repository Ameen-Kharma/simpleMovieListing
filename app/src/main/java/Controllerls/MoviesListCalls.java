package Controllerls;

import android.util.Log;

import com.tasks.android.yamsafertask.APIClient;
import com.tasks.android.yamsafertask.APIInterface;

import Models.Movie;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by asus on 1/28/2019.
 */

public class MoviesListCalls {
    private APIClient apiClient;
    private APIInterface apiInterface;
    getMoviesCallBackListner mListner;


    public MoviesListCalls(getMoviesCallBackListner listner) {
        apiClient = new APIClient();
        apiInterface= apiClient.getRetrofit().create(APIInterface.class);
        mListner = listner;
    }

    public void callMovies()
    {
        Call<Movie> call = apiInterface.getDiscoverMovies();

        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {


                Movie movie ;

                if(response.code()==200)
                {
                    movie = response.body();
                    mListner.onDoneCallMovies(movie);
                }


            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Log.e("Movie 0!!", "something went wrong while getting movies"+t.getMessage());

            }
        });
    }

    public interface getMoviesCallBackListner
    {
        public void onDoneCallMovies(Movie movie);
    }
}
