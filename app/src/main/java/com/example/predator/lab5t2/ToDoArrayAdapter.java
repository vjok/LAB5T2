package com.example.predator.lab5t2;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.predator.lab5t2.model.ToDoItem;
import com.example.predator.lab5t2.model.ToDoModel;

import java.util.ArrayList;

public class ToDoArrayAdapter extends ArrayAdapter<ToDoItem> {

    static final int VIEW_TYPE_COUNT = 1;
    static final int VIEW_TYPE= 2;

    public ToDoArrayAdapter(Context context, ArrayList<ToDoItem> items)
    {
        super(context,0,items);
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }


    @Override
    public int getItemViewType(int position) {
        ToDoItem item = getItem(position);
        return VIEW_TYPE;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ToDoItem item = getItem(position);


        if(convertView == null) {
            int layoutid = 0;
            layoutid = R.layout.new_list_item;
            convertView = LayoutInflater.from(getContext()).inflate(layoutid,parent,false);
        }

        //tänne luku
        //ToDoModel model = new ToDoModel(getContext());
        //ArrayList joo = model.getItemFromDb();
        TextView textViewTitle = convertView.findViewById(R.id.twTitle);
        textViewTitle.setText(item.getTitle());
        TextView textViewDescription = convertView.findViewById(R.id.twDescription);
        textViewDescription.setText(item.getDescription());
        TextView textViewTime = convertView.findViewById(R.id.twDate);
        textViewTime.setText(item.getDueDate());
        return convertView;
    }
}
