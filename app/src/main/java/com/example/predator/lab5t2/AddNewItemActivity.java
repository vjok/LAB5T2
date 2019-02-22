package com.example.predator.lab5t2;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import com.example.predator.lab5t2.model.ToDoItem;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddNewItemActivity extends AppCompatActivity {

    EditText editTextTitle, editTextDescription;
    DatePicker datePicker = null;
    Calendar calendar = null;
    int year, month, day = 0;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_item);
        editTextTitle = findViewById(R.id.etName);
        editTextDescription = findViewById(R.id.etDescription);
        datePicker = findViewById(R.id.dpPicker);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        datePicker.init(year,month,day,new DatePicker.OnDateChangedListener(){
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                date = dayOfMonth+"."+monthOfYear+"."+year;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        final String title = editTextTitle.getText().toString();
        final String description = editTextDescription.getText().toString();
        year = datePicker.getYear();
        month = datePicker.getMonth();
        day = datePicker.getDayOfMonth();

        ToDoItem item1 = new ToDoItem(title, description, date);
        Log.d("PASKE", "Lisätään: "+title+ " "+description+ " "+ date);
        returnData(item1);

        return true;
    }



    private void returnData(ToDoItem data)
    {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("ITEM", data);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}
