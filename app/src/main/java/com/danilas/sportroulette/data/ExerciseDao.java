package com.danilas.sportroulette.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.danilas.sportroulette.model.Exercise;

import java.util.List;

@Dao
public interface ExerciseDao {
    @Query("SELECT * FROM Exercise")
    List<Exercise> getAll();

    @Query("SELECT * FROM Exercise WHERE selected IS :first")
    List<Exercise> getAllTrue(boolean first);

    @Query("SELECT * FROM Exercise WHERE uid IS :value")
    Exercise findById(int value);

    @Insert
    void insert(Exercise exercise);

    @Update
    void update(Exercise exercise);

    @Delete
    void delete(Exercise exercise);

    @Query("DELETE FROM Exercise")
    void deleteAll();
}
