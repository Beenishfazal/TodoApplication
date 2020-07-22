package com.symb.task.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private List<TodoModel> todoModels;
    LayoutInflater inflter;

    public GridViewAdapter(Context context, List<TodoModel> todoModels) {
        this.context = context;
        this.todoModels = todoModels;
        inflter = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return todoModels.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=inflter.inflate(R.layout.todo_item_layout, null);
        TextView todo = (TextView) view.findViewById(R.id.text_todo_item);
        TextView dateTime = (TextView) view.findViewById(R.id.text_datetime);
        todo.setText(todoModels.get(i).todo);
        dateTime.setText(todoModels.get(i).dateTime);
        return view;
    }
}
