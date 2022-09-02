package com.danilas.sportroulette.screens;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.danilas.sportroulette.App;
import com.danilas.sportroulette.R;
import com.danilas.sportroulette.model.Exercise;

import java.util.List;

import com.danilas.sportroulette.model.ExerciseAdapter;

public class Exercises extends AppCompatActivity {

    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getInstance().hideStatusBar(this);
        setContentView(R.layout.activity_exercises);
        input = findViewById(R.id.text);
    }

    @Override
    protected void onResume() {
        super.onResume();
        makeListView();
    }

    public void onAddClick(View view) {
        String text = input.getText().toString();

        if(!text.isEmpty()){
            if (text.equals("delete")) {
                deleteAllTable();
                Toast.makeText(this, "Удалено", Toast.LENGTH_SHORT).show();
            } else if (text.matches("delete \\d+")) {
                deleteExercise(text);
                Toast.makeText(this, "Удалено", Toast.LENGTH_SHORT).show();
            } else {
                addExercise(text);
                Toast.makeText(this, "Добавлено", Toast.LENGTH_SHORT).show();
            }
            input.setText("");
        }

        if (text.isEmpty()) {
            Toast.makeText(this, "Введи название", Toast.LENGTH_SHORT).show();
        }

        makeListView();
    }

    public void onCheckBoxClicked(View view) {
        Exercise exercise = App.getInstance().getExerciseDao().findById(view.getId());
        exercise.selected = ((CheckBox) view).isChecked();
        App.getInstance().getExerciseDao().update(exercise);
        makeListView();
    }

    public void makeListView() {
        List<Exercise> exercises = App.getInstance().getExerciseDao().getAll();
        ExerciseAdapter adapter = new ExerciseAdapter(this, R.layout.item_layout, exercises);
        ((ListView) findViewById(R.id.list)).setAdapter(adapter);
    }

    public void deleteAllTable() {
        App.getInstance().getExerciseDao().deleteAll();
    }

    public void addExercise(String text) {
        Exercise exercise = new Exercise();
        exercise.exercise = text;
        exercise.selected = true;
        App.getInstance().getExerciseDao().insert(exercise);
    }

    public void deleteExercise(String text) {
        int uid = Integer.parseInt(text.substring(7));
        Exercise exercise = App.getInstance().getExerciseDao().findById(uid);
        if (exercise != null) {
            App.getInstance().getExerciseDao().delete(exercise);
        }
    }
}