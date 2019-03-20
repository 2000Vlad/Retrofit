package com.course.networking.retrofitmovies;

import java.util.List;

public interface OnGetMoviesCallback {
    void onSuccess(List<Movie> movies);
    void onFailure();
}
