package com.example.predator.lab5t2.model.db;

import android.provider.BaseColumns;

public final class ToDoItemContract {

    private ToDoItemContract(){}

    public static class DoItem implements BaseColumns{
        public static final String TABLE_NAME = "items";
        public static final String TITLE_NAME = "titlename";
        public static final String DESCRIPTION = "itemdescription";
        public static final String DUE_DATE = "duedate";
    }
}
