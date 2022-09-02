package com.danilas.sportroulette.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.danilas.sportroulette.model.Exercise;

@Database(entities = {Exercise.class}, version = 4)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ExerciseDao exerciseDao();
}

