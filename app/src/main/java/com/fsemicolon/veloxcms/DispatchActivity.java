package com.fsemicolon.veloxcms;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class DispatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch);

        //Let's get the Date Picker for dispatched Date


        EditText dispatchDateEditText = findViewById(R.id.dispatch_date_edit_text);

        dispatchDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                openDatePicker(dispatchDateEditText);
            }
        });


        //Let's get the Time Picker for dispatched Time

        EditText dispatchTimeEditText = findViewById(R.id.dispatch_time_edit_text);

        dispatchTimeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openTimePicker(dispatchTimeEditText);
            }
        });


    }


    /**
     * The following method is used for getting the date picker
     */

    public void openDatePicker(EditText editText)
    {

        //First let's get the current date

        Calendar calendar = Calendar.getInstance();

        //From this calendar we will get year, month and day

        int year = calendar.get(Calendar.YEAR);

        int month = calendar.get(Calendar.MONTH);

        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        //Since we have all of them let's open a datePickerDialog with today's date
        DatePickerDialog mDatePickerDialog  = new DatePickerDialog(DispatchActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                //ONCE THE DATE IS SELECTED WE SHOULD SHOW IT IN OUR EDIT TEXT

                String selectedDate = dayOfMonth+ "/" +(month+1)+ "/"+year;

                editText.setText(selectedDate);
            }
        },year,month,dayOfMonth);

        mDatePickerDialog.show();

    }

    /**
     * The following method is used for getting the time picker
     */

    public void openTimePicker(EditText editText)
    {

        Calendar calendar = Calendar.getInstance();

        //Let's get the current time from our Calendar

        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        int minutes = calendar.get(Calendar.MINUTE);


        TimePickerDialog timePickerDialog = new TimePickerDialog(DispatchActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                String amPm = null;

                if (calendar.get(Calendar.AM_PM)== Calendar.AM)
                {
                    amPm = " AM";
                }
                else if (calendar.get(Calendar.AM_PM)==Calendar.PM)
                {
                    amPm = " PM";
                }

                if (hourOfDay>=13)
                {
                    hourOfDay = hourOfDay-12;
                }

                String currentTime = String.format("%02d:%02d",hourOfDay,minute) + amPm;

                editText.setText(currentTime);


            }
        },hourOfDay,minutes,false);


        timePickerDialog.show();
    }


}