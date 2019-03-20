package com.course.networking.retrofitmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.course.networking.OnGetUsersCallback;
import com.course.networking.R;
import com.course.networking.User;

import java.util.List;

public class MoviesActivity extends AppCompatActivity {
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        mTextView = findViewById(R.id.textView2);
        OnGetMoviesCallback callback = new OnGetMoviesCallback() {
            @Override
            public void onSuccess(List<Movie> movies) {
                mTextView.setText("");
                for(Movie movie : movies){
                    mTextView.append(movie.toString()+" ");
                }
            }

            @Override
            public void onFailure() {
             mTextView.setText("Could not get the movies");
            }
        };
        MoviesController controller = MoviesController.getInstance();
        controller.getPopularMovies(callback);
    }
}
