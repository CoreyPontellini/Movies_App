package com.example.mymoviesappassignment2;

public class MovieItem {

    int image;
    String title, showingDate;
    private boolean isSelected;

    public MovieItem(int image, String title, String showingDate) {
        this.image = image;
        this.title = title;
        this.showingDate = showingDate;
        this.isSelected = false;
    }

    public String getTitle() {
        return title;
    }

    public String getShowingDate() {
        return showingDate;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
