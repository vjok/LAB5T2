package com.example.predator.lab5t2.model;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.provider.BaseColumns;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.example.predator.lab5t2.MainActivity;
import com.example.predator.lab5t2.model.db.ToDoItemContract;
import com.example.predator.lab5t2.model.db.ToDoItemDbHelper;

import java.util.ArrayList;

public class ToDoModel {

    ToDoItemDbHelper dbHelper = null;
    SQLiteDatabase testi = null;

    public ToDoModel(Context context)
    {
        this.dbHelper = new ToDoItemDbHelper(context);
        testi = dbHelper.getReadableDatabase();
    }

    public ToDoModel() {

    }

    public void addItemToDb(ToDoItem addable)
    {
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ToDoItemContract.DoItem.TITLE_NAME, addable.itemTitle);
        values.put(ToDoItemContract.DoItem.DESCRIPTION, addable.itemDescription);
        values.put(ToDoItemContract.DoItem.DUE_DATE, addable.dueDate);
        long newRowId = database.insert(ToDoItemContract.DoItem.TABLE_NAME, null, values);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public ArrayList getItemFromDb()
    {
        SQLiteDatabase db = null;
        String selectQuery = "SELECT * FROM " + ToDoItemContract.DoItem.TABLE_NAME;
        Cursor cursor = testi.rawQuery(selectQuery, null, null);
        ArrayList dataModelArrayList = new ArrayList();

        if(cursor.moveToFirst()){
            do{
                ToDoItem toDoItem = new ToDoItem();
                toDoItem.setTitle(cursor.getString(cursor.getColumnIndex(ToDoItemContract.DoItem.TITLE_NAME)));
                toDoItem.setDescription(cursor.getString(cursor.getColumnIndex(ToDoItemContract.DoItem.DESCRIPTION)));
                toDoItem.setDueDate(cursor.getString(cursor.getColumnIndex(ToDoItemContract.DoItem.DUE_DATE)));
                dataModelArrayList.add(toDoItem);
            }while (cursor.moveToNext());
        }
        return dataModelArrayList;
    }


    public void deleteItemFromDb(int id)
    {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        String[] args = new String[] {""+id+""};
        database.delete(ToDoItemContract.DoItem.TABLE_NAME, ToDoItemContract.DoItem._ID + " = ?", args);
    }
}
