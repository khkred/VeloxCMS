package com.fsemicolon.veloxcms;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button rSubmitButton;

    Spinner encodingSpinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rSubmitButton = findViewById(R.id.r_submit_btn);

        /**
         * The following code is used for populating the spinner with string array
         */


        encodingSpinner = findViewById(R.id.encoding_spinner);

        //First we need an Array Adapter

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,R.array.encoding_for_array,
                android.R.layout.simple_spinner_item);

        // We again need to set the layout when choice of items appear

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Apply this adapter to the spinner

        encodingSpinner.setAdapter(spinnerAdapter);


        /**
         * ==== END OF SPINNER CODE =====
         */

        //Let's try to get the date picker when edit text is clicked


        EditText receivedDateEditText = findViewById(R.id.received_date_edit_text);


        receivedDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               openDatePicker(receivedDateEditText);
            }
        });




        rSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this,DispatchActivity.class);

                startActivity(intent);
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
       DatePickerDialog mDatePickerDialog  = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                //ONCE THE DATE IS SELECTED WE SHOULD SHOW IT IN OUR EDIT TEXT

                String selectedDate = dayOfMonth+ "/" +(month+1)+ "/"+year;

                editText.setText(selectedDate);
            }
        },year,month,dayOfMonth);

        mDatePickerDialog.show();


    }

}


















