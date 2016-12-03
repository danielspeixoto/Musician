package com.danielspeixoto.musician.model.pojo;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import com.danielspeixoto.musician.util.Contract;

import java.util.ArrayList;

import lombok.Data;

/**
 * Created by danielspeixoto on 13/11/16.
 */
@Data
public class Task extends Contract.TaskColumns implements Parcelable {
    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };
    private int id;
    private String name;
    private String description;
    private ArrayList<ToDo> toDos;

    public Task() {
    }

    public Task(Cursor cursor) {
        id = cursor.getColumnIndex(_ID) != -1 ?
                cursor.getInt(cursor.getColumnIndex(_ID)) : 0;
        name = cursor.getColumnIndex(NAME) != -1 ?
                cursor.getString(cursor.getColumnIndex(NAME)) : null;
        description = cursor.getColumnIndex(DESCRIPTION) != -1 ?
                cursor.getString(cursor.getColumnIndex(DESCRIPTION)) : null;

    }

    protected Task(Parcel in) {
        id = in.readInt();
        name = in.readString();
        description = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(description);
    }
}
