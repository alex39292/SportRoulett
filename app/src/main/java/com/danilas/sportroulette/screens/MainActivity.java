package com.danilas.sportroulette.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.danilas.sportroulette.App;
import androidx.appcompat.app.AppCompatActivity;

import com.danilas.sportroulette.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getInstance().hideStatusBar(this);
        setContentView(R.layout.activity_main);
    }

    public void onExercisesClick(View view) {
        startActivity(new Intent(this, Exercises.class));
    }
    public void onPlayClick(View view) {
        startActivity(new Intent(this, Play.class));
    }
}