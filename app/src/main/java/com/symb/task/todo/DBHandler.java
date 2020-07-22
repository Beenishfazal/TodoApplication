package com.symb.task.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Todo";
    private static final String TABLE_TODO_ITEMS = "TodoItems";
    private static final String KEY_TODO_ITEM = "TodoItem";
    private static final String KEY_DATETIME = "DateTime";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STUDENTS_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_TODO_ITEMS + "("
                + KEY_TODO_ITEM + " TEXT, "
                + KEY_DATETIME + " TEXT" + ")";

        db.execSQL(CREATE_STUDENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO_ITEMS);
        onCreate(db);
    }
    public void addTODo(TodoModel todo) {
        SQLiteDatabase db = this.getWritableDatabase();

        //Content values use KEY-VALUE pair concept
        ContentValues values = new ContentValues();
        values.put(KEY_TODO_ITEM, todo.getTodo());
        values.put(KEY_DATETIME, todo.getDateTime());

        db.insert(TABLE_TODO_ITEMS, null, values);
        db.close();
    }
    public List<TodoModel> getAllTodoItems(){
     List<TodoModel> todoModelList = new ArrayList<TodoModel>();
        String selectQuery = "SELECT  * FROM " + TABLE_TODO_ITEMS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                TodoModel todo = new TodoModel(
                        cursor.getString(0),
                        cursor.getString(1));

                todoModelList.add(todo);
            } while (cursor.moveToNext());
        }

        return  todoModelList;
    }
}
