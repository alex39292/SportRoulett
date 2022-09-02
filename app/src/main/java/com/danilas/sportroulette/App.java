package com.danilas.sportroulette;

import android.app.Application;
import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

import androidx.room.Room;

import com.danilas.sportroulette.data.AppDatabase;
import com.danilas.sportroulette.data.ExerciseDao;

public class App extends Application {

    private static App instance;

    private AppDatabase database;
    private ExerciseDao exerciseDao;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app-db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        exerciseDao = database.exerciseDao();
    }

    public AppDatabase getDatabase() {
        return database;
    }

    public void setDatabase(AppDatabase database) {
        this.database = database;
    }

    public ExerciseDao getExerciseDao() {
        return exerciseDao;
    }

    public void setExerciseDao(ExerciseDao exerciseDao) {
        this.exerciseDao = exerciseDao;
    }

    public void hideStatusBar(Activity activity) {
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
