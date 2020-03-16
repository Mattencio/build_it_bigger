package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.jokemodule.JokeActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void getJoke() {
        new EndpointsAsyncTask().execute(joke -> {
            Intent intent = new Intent(this, JokeActivity.class);
            intent.putExtra(JokeActivity.RECEIVED_JOKE, joke);
            startActivity(intent);
        });
    }

    public void tellJoke(View view) {
        getJoke();
    }
}
