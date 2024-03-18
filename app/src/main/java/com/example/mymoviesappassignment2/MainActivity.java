package com.example.mymoviesappassignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements MovieClickListener {

    ArrayList<MovieItem> movieItems = new ArrayList<>();
    ArrayList<MovieItem> selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.movieRecyclerView);
        Intent serviceIntent = new Intent(this,BackgroundMusicService.class);
        startService(serviceIntent); // Start Music Service in background on app start

        //Add Movie Items to arrayList
        movieItems.add(new MovieItem(R.drawable.jawscover, "Jaws", "June 20, 1975"));
        movieItems.add(new MovieItem(R.drawable.alienfilmcover, "Alien", "June 22, 1979"));
        movieItems.add(new MovieItem(R.drawable.aquamancover, "Aquaman", "December 21, 2018"));
        movieItems.add(new MovieItem(R.drawable.barbiecover, "Barbie", "July 21, 2023"));
        movieItems.add(new MovieItem(R.drawable.beekeepercover, "The Beekeeper", "January 12, 2024"));
        movieItems.add(new MovieItem(R.drawable.braveheartcover, "Braveheart", "May 24, 1995"));
        movieItems.add(new MovieItem(R.drawable.dunecover, "Dune", "October 22, 2021"));
        movieItems.add(new MovieItem(R.drawable.exorcistcover, "The Exorcist", "December 26, 1973"));
        movieItems.add(new MovieItem(R.drawable.godfatherfilmcover, "The Godfather", "March 24, 1972"));
        movieItems.add(new MovieItem(R.drawable.guardianscover, "Guardians of the Galaxy", "August 1, 2014"));
        movieItems.add(new MovieItem(R.drawable.homealonecover, "Home Alone", "November 16, 1990"));
        movieItems.add(new MovieItem(R.drawable.interstellarfilmcover, "Interstellar", "November 7, 2014"));
        movieItems.add(new MovieItem(R.drawable.jokercover, "Joker", "October 4, 2019"));
        movieItems.add(new MovieItem(R.drawable.littleshopcover, "Little Shop of Horrors", "December 19, 1986"));
        movieItems.add(new MovieItem(R.drawable.matrixcover, "The Matrix", "March 31, 1999"));
        movieItems.add(new MovieItem(R.drawable.megcover, "The Meg", "August 10, 2018"));
        movieItems.add(new MovieItem(R.drawable.oppenheimer__film_cover, "Oppenheimer", "July 21, 2023"));
        movieItems.add(new MovieItem(R.drawable.rockycover, "Rocky", "December 3, 1976"));
        movieItems.add(new MovieItem(R.drawable.scream__1996_film__poster, "Scream", "December 20, 1996"));
        movieItems.add(new MovieItem(R.drawable.stepbrotherscover, "Step Brothers", "July 25, 2008"));
        movieItems.add(new MovieItem(R.drawable.tenetcover, "Tenet", "September 3, 2020"));
        movieItems.add(new MovieItem(R.drawable.wishcover, "Wish", "November 22, 2023"));


        movieAdapter adapter = new movieAdapter(this, movieItems);

        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
    }

    @Override // Long Click to select/deselect movie implement method from interface
    public void onSelectionLongClick(View view, int position) {

        MovieItem movie = movieItems.get(position);
        if (selection.contains(movie)) {
            selection.remove(movie);
            movie.setSelected(true);
        }
    }

}
