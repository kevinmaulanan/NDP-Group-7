package com.example.zesmart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.naishadhparmar.zcustomcalendar.CustomCalendar;
import org.naishadhparmar.zcustomcalendar.OnDateSelectedListener;
import org.naishadhparmar.zcustomcalendar.Property;

import java.util.Calendar;
import java.util.HashMap;

public class ScheduleActivity extends AppCompatActivity {
    //initialize variable
    CustomCalendar customCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        //Assign variable
        customCalendar = findViewById(R.id.Calendar);

        //initialize description hash Map
        HashMap<Object, Property> descHashMap = new HashMap<>();
        //Initialize default property
        Property defaultProperty = new Property();
        //Initialize default resource
        defaultProperty.layoutResource = R.layout.default_view;
        //Initialize and assign variable
        defaultProperty.dateTextViewResource = R.id.Text_view;
        //put object and property
        descHashMap.put("default", defaultProperty);

        //For current date
        Property currentProperty = new Property();
        currentProperty.layoutResource = R.layout.current_view;
        currentProperty.dateTextViewResource = R.id.Text_view;
        descHashMap.put("current", currentProperty);

        //For present date
        Property presentProperty = new Property();
        presentProperty.layoutResource = R.layout.present_view;
        presentProperty.dateTextViewResource = R.id.Text_view;
        descHashMap.put("present", presentProperty);

        //For absent
        Property absentProperty = new Property();
        absentProperty.layoutResource = R.layout.absent_view;
        absentProperty.dateTextViewResource = R.id.Text_view;
        descHashMap.put("absent", absentProperty);

        //set desc hash map on custom calendar
        customCalendar.setMapDescToProp(descHashMap);

        //Initialize date hash map
        HashMap<Integer, Object> dateHashMap = new HashMap<>();
        //Initialize Calendar
        Calendar calendar = Calendar.getInstance();
        //put values
        dateHashMap.put(calendar.get(Calendar.DAY_OF_MONTH), "current");
        dateHashMap.put(1,"present");
        dateHashMap.put(2,"absent");
        dateHashMap.put(3,"present");
        dateHashMap.put(4,"absent");
        dateHashMap.put(20,"present");
        dateHashMap.put(30,"absent");
        //set date
        customCalendar.setDate(calendar,dateHashMap);

        customCalendar.setOnDateSelectedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(View view, Calendar selectedDate, Object desc) {
                //Get string date
                String sDate = selectedDate.get(Calendar.DAY_OF_MONTH)
                        +"/" + (selectedDate.get(Calendar.MONTH) + 1)
                        +"/" + selectedDate.get(Calendar.YEAR);
                //Display date in toast
                Toast.makeText(getApplicationContext()
                        ,sDate,Toast.LENGTH_SHORT).show();

            }
        });
    }
}