package com.danielspeixoto.musician.model.pojo;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import com.danielspeixoto.musician.util.Contract;

import lombok.Data;

/**
 * Created by danielspeixoto on 13/11/16.
 */
@Data
public class ToDo extends Contract.ToDoColumns implements Parcelable {
    public static final Creator<ToDo> CREATOR = new Creator<ToDo>() {
        @Override
        public ToDo createFromParcel(Parcel in) {
            return new ToDo(in);
        }

        @Override
        public ToDo[] newArray(int size) {
            return new ToDo[size];
        }
    };
    private long id;
    private long taskId = -1; // Default Value
    private String description;
    private boolean isFinished;

    public ToDo(Cursor cursor) {
        id = cursor.getInt(cursor.getColumnIndex(_ID));
        taskId = cursor.getInt(cursor.getColumnIndex(TASK_ID));
        description = cursor.getString(cursor.getColumnIndex(DESCRIPTION));
        isFinished = cursor.getInt(cursor.getColumnIndex(IS_FINISHED)) == 1;
    }

    public ToDo(String description) {
        this.description = description;
    }

    protected ToDo(Parcel in) {
        id = in.readInt();
        taskId = in.readLong();
        description = in.readString();
        isFinished = in.readByte() != 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeLong(taskId);
        dest.writeString(description);
        dest.writeByte((byte) (isFinished ? 1 : 0));
    }
}
