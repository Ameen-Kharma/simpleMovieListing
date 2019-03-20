package com.tasks.android.yamsafertask;

/**
 * Created by asus on 1/28/2019.
 */


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



/**
 * Created by asus on 1/3/2019.
 */

public class APIClient {
    private static Retrofit retrofit = null;

    public APIClient( ){

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
    public Retrofit getRetrofit(){
        return retrofit;
    }


}

