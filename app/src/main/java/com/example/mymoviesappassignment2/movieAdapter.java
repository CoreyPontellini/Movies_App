package com.example.mymoviesappassignment2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class movieAdapter extends RecyclerView.Adapter<movieAdapter.View_Holder> {

    Context context;
   private static ArrayList<MovieItem> arrayList; // Arraylist to hold all movies
   private static ArrayList<MovieItem> selectedMovie; //ArrayList to hold the selections by user
   private MovieClickListener movieClickListener;

    public movieAdapter (Context context, ArrayList<MovieItem> arrayList){
        this.context = context;
        this.arrayList = arrayList;
        selectedMovie = new ArrayList<>();
    }


    @NonNull
    @Override
    public View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movierowitem,parent,false);
        return new View_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull View_Holder holder, int position) {
        MovieItem movie = arrayList.get(position);
        holder.image.setImageResource(arrayList.get(position).image);
        holder.title.setText(arrayList.get(position).title);
        holder.showingDate.setText(arrayList.get(position).showingDate);

        // change background around selection, blue for default/remove selection/red for selected movie
        if (movie.isSelected()) {
            holder.itemView.setBackgroundColor(Color.RED);
        } else {
            holder.itemView.setBackgroundColor(Color.BLUE);
        }

    }

    @Override
    public int getItemCount() {return arrayList.size();}

    class View_Holder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
    TextView title, showingDate;
    ImageView image;
    boolean normalClickEnabled;

     View_Holder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.movieImage);
        title = itemView.findViewById(R.id.movieTitleTV);
        showingDate = itemView.findViewById(R.id.showingDate);
        itemView.setOnLongClickListener(this);

    }
        @Override
        public boolean onLongClick(View v) {
        int position = getAdapterPosition();
        if (position != RecyclerView.NO_POSITION){
            MovieItem movie = arrayList.get(position);
            // check if the selection contains a movie and remove the choice then toast to note the deselection
            if (selectedMovie.contains(movie)) {
                selectedMovie.remove(movie);
                movie.setSelected(false);
                Toast.makeText(context, movie.getTitle() + " Deselected  ", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged(); // explicitely let the RecyclerView know when the data set is changed between the updated Views
            } else {
                // check to see if there are one/two movies selected then concatenate the 2nd movie to the toast message to display both going from 1-2
                if(selectedMovie.size() < 2){
                    selectedMovie.add(movie);
                    movie.setSelected(true);
                    if (selectedMovie.size() == 2) {
                        String twoSelectedMovies = selectedMovie.get(0).getTitle() + " and " + selectedMovie.get(1).getTitle();
                        Toast.makeText(context,"Selected Movies : " + twoSelectedMovies, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context,movie.getTitle() + " Selected", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Let the user know they cannot select more than two movies
                    Toast.makeText(context, "You cannot selected more than two Movies!",Toast.LENGTH_LONG).show();
                }

                notifyDataSetChanged();
            }
            return true;
        }
            return false;
        }

    }
}

