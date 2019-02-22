package com.example.predator.lab5t2.model.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.predator.lab5t2.model.ToDoItem;

import java.util.LinkedList;
import java.util.List;

public class ToDoItemDbHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ToDoItemContract.DoItem.TABLE_NAME + " (" +
                    ToDoItemContract.DoItem._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    ToDoItemContract.DoItem.TITLE_NAME + " TEXT, " +
                    ToDoItemContract.DoItem.DESCRIPTION + " TEXT, " +
                    ToDoItemContract.DoItem.DUE_DATE + " TEXT )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ToDoItemContract.DoItem.TABLE_NAME;

    private static final String SQL_DELETE_TASK =
            "DELETE FROM " + ToDoItemContract.DoItem.TABLE_NAME + " WHERE " +ToDoItemContract.DoItem._ID;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "itemDatabase2.db";

    public ToDoItemDbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}




































    /*

    private static final String TABLE_ITEMS = "items";
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";

    private static final String[] COLUMNS = {KEY_ID,KEY_TITLE,KEY_DESCRIPTION};

    public void addItem(ToDoItem item)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, item.getTitle());
        values.put(KEY_DESCRIPTION, item.getDescription());

        db.insert(TABLE_ITEMS, null, values);
        db.close();
    }

    public ToDoItem getItem(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor =
                db.query(TABLE_ITEMS,
                        COLUMNS,
                        " id = ?",
                        new String[] { String.valueOf(id) },
                        null,
                        null,
                        null,
                        null);

        if (cursor != null)
            cursor.moveToFirst();

        ToDoItem item = new ToDoItem();
        item.setId(Integer.parseInt(cursor.getString(0)));
        item.setTitle(cursor.getString(1));
        item.setDescription(cursor.getString(2));

        Log.d("getBook("+id+")", item.toString());

        return item;
    }

    public List<ToDoItem> getAllBooks() {
        List<ToDoItem> items = new LinkedList<ToDoItem>();

        String query = "SELECT  * FROM " + TABLE_ITEMS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        ToDoItem item = null;
        if (cursor.moveToFirst()) {
            do {
                item = new ToDoItem();
                item.setId(Integer.parseInt(cursor.getString(0)));
                item.setTitle(cursor.getString(1));
                item.setDescription(cursor.getString(2));

                items.add(item);
            } while (cursor.moveToNext());
        }
        Log.d("getAllBooks()", items.toString());

        return items;
    } */

