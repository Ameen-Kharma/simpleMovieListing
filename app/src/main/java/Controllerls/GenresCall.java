package Controllerls;

import android.util.Log;

import com.tasks.android.yamsafertask.APIClient;
import com.tasks.android.yamsafertask.APIInterface;

import java.util.HashMap;
import java.util.Map;

import Models.GenresClass;
import Models.Movie;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by asus on 1/28/2019.
 */

public class GenresCall {

    private APIClient apiClient;
    private APIInterface apiInterface;
    GetGenresCallBackListner mListner;

    public GenresCall(GetGenresCallBackListner listner) {
        apiClient = new APIClient();
        apiInterface= apiClient.getRetrofit().create(APIInterface.class);
        mListner = listner;
    }

    public void callGeneres()
    {
        Call<GenresClass> call = apiInterface.getMoviesGenre();
        call.enqueue(new Callback<GenresClass>() {
            @Override
            public void onResponse(Call<GenresClass> call, Response<GenresClass> response) {
                GenresClass genres ;

                if(response.code()==200)
                {
                    genres = response.body();
                    mListner.onDoneCallGenres(genres);
                }


            }

            @Override
            public void onFailure(Call<GenresClass> call, Throwable t) {
                Log.e("Genre 0!!", "something went wrong while getting genres"+t.getMessage());

            }
        });

    }
    public interface GetGenresCallBackListner
    {
        public void onDoneCallGenres(GenresClass genres);
    }
}
