package com.symb.task.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class TodoListActivity extends AppCompatActivity {
 GridView todoGrid;
 List<TodoModel> gridValue;
 DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setTitle("Todo Items");
        super.onCreate(savedInstanceState);
        db = new DBHandler(this);
        setContentView(R.layout.activity_todo_list);

        todoGrid=(GridView)this.findViewById(R.id.grid_todo);
        gridValue = db.getAllTodoItems();
        todoGrid.setAdapter(new GridViewAdapter(getApplicationContext(),gridValue));
    }
}