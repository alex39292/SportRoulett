package com.danilas.sportroulette.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.danilas.sportroulette.R;
import com.danilas.sportroulette.model.Exercise;
import com.danilas.sportroulette.App;

import java.util.List;
import java.util.Random;

public class Play extends AppCompatActivity {

    private List<Exercise> exercises;
    private ImageView image;
    private AnimatedVectorDrawable animation;
    private Animation resultAnimation;
    private TextView resultView;
    private int countTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getInstance().hideStatusBar(this);
        setContentView(R.layout.activity_play);
        resultView = findViewById(R.id.resultView);
        image = findViewById(R.id.animNumbers);
        resultAnimation = AnimationUtils.loadAnimation(this, R.anim.show_result);
        countTextView = 0;
    }

    @Override
    protected void onResume() {
        super.onResume();
        exercises = App.getInstance().getExerciseDao().getAllTrue(true);
        image.setBackgroundResource(R.drawable.animated_numbers);
        animation = (AnimatedVectorDrawable) image.getBackground();
    }

    public void onGenerateClick(View view) {
        view.setClickable(false);
        if (!exercises.isEmpty()){
            animation.start();
            resultView.postDelayed(() -> {
                setTextToView(getRandomExercise());
                resultView.startAnimation(resultAnimation);
                view.setClickable(true);
            }, 3000);
        } else {
            Toast.makeText(this, "Добавь хотя бы один пункт", Toast.LENGTH_SHORT).show();
        }
    }

    public String getRandomExercise() {
        Exercise exercise = exercises.get(new Random().nextInt(exercises.size()));
        return getString(R.string.concat_uid_text, exercise.uid, exercise.exercise);
    }

    public void setTextToView(String text) {
        if (countTextView == 3) {
            resultView.setText(text);
            countTextView = 1;
        } else {
            resultView.append("\n" + text);
            countTextView++;
        }
    }
}