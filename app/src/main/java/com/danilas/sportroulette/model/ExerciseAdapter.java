package com.danilas.sportroulette.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.danilas.sportroulette.R;

import java.util.List;

public class ExerciseAdapter extends ArrayAdapter<Exercise> {

    private final LayoutInflater inflater;
    private final int layout;
    private final List<Exercise> exercises;

    public ExerciseAdapter(@NonNull Context context, int resource, List<Exercise> exercises) {
        super(context, resource, exercises);
        this.exercises = exercises;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        Context context = this.getContext();

        View view=inflater.inflate(this.layout, parent, false);

        TextView textView = view.findViewById(R.id.textView);
        CheckBox checkBoxView = view.findViewById(R.id.checkBox);

        Exercise exercise = exercises.get(position);

        textView.setText(context.getString(R.string.concat_uid_text,exercise.uid,exercise.exercise));
        if (exercise.selected) {
            checkBoxView.setChecked(true);
        }
        checkBoxView.setId(exercise.uid);

        return view;
    }
}
