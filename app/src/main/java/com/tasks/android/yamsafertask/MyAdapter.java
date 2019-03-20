package com.tasks.android.yamsafertask;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Models.Genre;
import Models.Result;

/**
 * Created by asus on 1/28/2019.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{



    private List<Result> adapterList;
    private View v;
    private Context context;
    public Map<Integer, String> getGenerMap() {
        return generMap;
    }

    public void setGenerMap(Map<Integer, String> generMap) {
        this.generMap = generMap;
    }

    private Map<Integer, String> generMap = new HashMap<Integer, String>();


    public MyAdapter(List<Result> adapterList, Context c) {

        this.adapterList = adapterList;
        context = c;
    }




    public List<Result> getAdapterList() {
        return adapterList;
    }

    public void setAdapterList(List<Result> adapterList) {
        this.adapterList = adapterList;
    }

    public class ItemsViewHolder extends RecyclerView.ViewHolder
    {
        TextView movieName,genre,popularity,discreption,releaseDate;
        ImageView movieImage;

        public ItemsViewHolder(View itemView) {
            super(itemView);
            movieName = (TextView) itemView.findViewById(R.id.movie_name);
            genre = (TextView) itemView.findViewById(R.id.catagory);
            popularity = (TextView) itemView.findViewById(R.id.popularity);
            discreption = (TextView) itemView.findViewById(R.id.discreption);
            releaseDate = (TextView) itemView.findViewById(R.id.release_date);
            movieImage = (ImageView) itemView.findViewById(R.id.image);

        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_cell, parent, false);
        return new ItemsViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

         Result result = adapterList.get(position);

         String gener = "";

        for(int i=0;i<result.getGenreIds().size();i++)
        {
            int key = result.getGenreIds().get(i);
            gener+=generMap.get(key);
            if(i<result.getGenreIds().size()-1)
                gener +=", ";
        }

         ItemsViewHolder viewHolder = (ItemsViewHolder)holder;
         viewHolder.movieName.setText(result.getTitle());
         viewHolder.discreption.setText(result.getOverview());
         viewHolder.genre.setText(gener);

         String imageUrl = "https://image.tmdb.org/t/p/w500"+result.getPosterPath();
         Picasso.with(context).load(imageUrl).into(viewHolder.movieImage);

        String header = result.getReleaseDate();
        header.replaceAll("-","/");

        //SimpleDateFormat sm = new SimpleDateFormat("mm-dd-yyyy");
       // String strDate = sm.format(header);

        Date date = new Date();

        try {
            date = new SimpleDateFormat("d, MMM, yyyy").parse(header);

            viewHolder.releaseDate.setText(""+date);
        } catch (ParseException e) {
            e.printStackTrace();
        }



    }

    @Override
    public int getItemCount() {
        return adapterList.size();
    }
}
