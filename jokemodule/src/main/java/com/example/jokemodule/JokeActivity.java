package com.example.jokemodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String RECEIVED_JOKE = "received_joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(RECEIVED_JOKE)) {
            String receivedJoke = intent.getStringExtra(RECEIVED_JOKE);
            displayJoke(receivedJoke);
        } else {
            displayJoke(getString(R.string.joke_error));
        }
    }

    private void displayJoke(String receivedJoke) {
        TextView tvReceivedJoke = findViewById(R.id.tv_received_joke);
        tvReceivedJoke.setText(receivedJoke);
    }
}