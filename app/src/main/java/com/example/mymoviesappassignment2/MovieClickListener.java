package com.example.mymoviesappassignment2;

import android.view.View;

// implement interface for a movie click listener that takes the view and position for selections

public interface MovieClickListener {
    void onSelectionLongClick(View view, int position);
}
