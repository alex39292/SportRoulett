package com.danilas.sportroulette.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
public class Exercise implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "exercise")
    public String exercise;

    @ColumnInfo(name = "selected")
    public boolean selected;

    public Exercise() {
    }

    protected Exercise(Parcel in) {
        uid = in.readInt();
        exercise = in.readString();
        selected = in.readByte() != 0;
    }

    public static final Creator<Exercise> CREATOR = new Creator<Exercise>() {
        @Override
        public Exercise createFromParcel(Parcel in) {
            return new Exercise(in);
        }

        @Override
        public Exercise[] newArray(int size) {
            return new Exercise[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise1 = (Exercise) o;
        return uid == exercise1.uid && selected == exercise1.selected && Objects.equals(exercise, exercise1.exercise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, exercise, selected);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(uid);
        parcel.writeString(exercise);
        parcel.writeByte((byte) (selected ? 1 : 0));
    }
}
