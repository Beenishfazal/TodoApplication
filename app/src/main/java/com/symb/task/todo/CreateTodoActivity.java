package com.symb.task.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class CreateTodoActivity extends AppCompatActivity {
    Button save;
    EditText toDoItem;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_todo);
        db = new DBHandler(this);
        save=(Button)this.findViewById(R.id.btn_save_todo);
        toDoItem=(EditText)this.findViewById(R.id.input_text_todo_item);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String todo=toDoItem.getText().toString().trim();
                DateFormat Date = DateFormat.getDateInstance();
                Date currentTime = Calendar.getInstance().getTime();
                String dateTime = Date.format(currentTime);
                if(todo!=""){
                    Log.d("CreateTODO", "Inserting ..");
                    db.addTODo(new TodoModel(todo,dateTime));
                    Intent mainIntent = new Intent(CreateTodoActivity.this,MainActivity.class);
                    CreateTodoActivity.this.startActivity(mainIntent);
                    CreateTodoActivity.this.finish();
                }
            }
        });

    }
}