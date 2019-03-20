package com.tasks.android.yamsafertask;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import Controllerls.GenresCall;
import Controllerls.MoviesListCalls;
import Models.Genre;
import Models.GenresClass;
import Models.Movie;
import Models.Result;

public class MainActivity extends AppCompatActivity implements MoviesListCalls.getMoviesCallBackListner, GenresCall.GetGenresCallBackListner {

    private TextView mTextMessage;
    private List<Result> moviesList;
    Movie movie;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MyAdapter myAdapter;
    GenresClass genresClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.movies_recycler);
        mTextMessage = (TextView) findViewById(R.id.message);

        GenresCall genresCall = new GenresCall(this);
        genresCall.callGeneres();
    }

    @Override
    public void onDoneCallMovies(Movie movieFromCall) {

        movie = movieFromCall;
        moviesList =  movie.getResults();
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        myAdapter = new MyAdapter(moviesList,this);
        myAdapter.setGenerMap(genresClass.getMap());
        recyclerView.setAdapter(myAdapter);


    }

    @Override
    public void onDoneCallGenres(GenresClass genres) {

        genresClass = genres;
        MoviesListCalls moviesListCalls = new MoviesListCalls(this);
        moviesListCalls.callMovies();

    }
}
