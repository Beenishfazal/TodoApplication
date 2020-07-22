package com.symb.task.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button createButton;
    Button toDoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createButton =(Button)this.findViewById(R.id.btn_create);
        toDoButton =(Button)this.findViewById(R.id.btn_todo_list);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(MainActivity.this,CreateTodoActivity.class);
                MainActivity.this.startActivity(mainIntent);
            }
        });
        toDoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(MainActivity.this,TodoListActivity.class);
                MainActivity.this.startActivity(mainIntent);
            }
        });
    }
}