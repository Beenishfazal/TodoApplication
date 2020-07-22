package com.symb.task.todo;

public class TodoModel {
    String todo;
    String dateTime;

    public TodoModel(String todo,String dateTime){
        this.dateTime = dateTime;
        this.todo = todo;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
