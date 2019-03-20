package com.course.networking.retrofitmovies;

import android.util.Log;

import com.course.networking.BuildConfig;
import com.course.networking.OnGetUsersCallback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesController implements Callback<MovieList> {
    public static final String API_KEY = "20d09bc1e7538ac467b18f991142a223";
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static MoviesController sController;
    private MoviesController(MovieApi api){
        mApi = api;
    }
    private MovieApi mApi;
    public static MoviesController getInstance(){
        if(sController == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            sController = new MoviesController(retrofit.create(MovieApi.class));
        }
        return sController;
    }

    public void getPopularMovies(final OnGetMoviesCallback callback){
        mCallback = callback;
        mApi.getPopularMovies(API_KEY,"en-US",1).enqueue(this);
    }
    private OnGetMoviesCallback mCallback;
    @Override
    public void onResponse(Call<MovieList> call, Response<MovieList> response) {
       if(response.isSuccessful()){
           List<Movie> movies = response.body().getMovies();
           mCallback.onSuccess(movies);
       }
       else{
           Log.e("Not ok","Response is not successful");
       }
    }

    @Override
    public void onFailure(Call<MovieList> call, Throwable t) {
        Log.e("Exception",Log.getStackTraceString(t));
        mCallback.onFailure();
    }
}
