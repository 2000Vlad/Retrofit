package com.course.networking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class GithubActivity extends AppCompatActivity {

    private UsersRepository mUsersRepository;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github);
        mTextView = findViewById(R.id.textView);
        mUsersRepository = UsersRepository.getInstance();

        mUsersRepository.getUsers(new OnGetUsersCallback() {
            @Override
            public void onSuccess(List<User> users) {
                Toast.makeText(GithubActivity.this,"Github users = "+ users.toString(),Toast.LENGTH_SHORT);
                for(User user : users) mTextView.append(user.toString()+" ");

            }

            @Override
            public void onError() {
                Toast.makeText(GithubActivity.this,"error Github users = "+ "check the code :D ",Toast.LENGTH_SHORT);
            }
        });
    }
}
