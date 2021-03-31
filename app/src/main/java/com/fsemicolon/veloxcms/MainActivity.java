package com.fsemicolon.veloxcms;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button rSubmitButton;

    Spinner encodingSpinner;

    LinearLayout reelsLayout;

    //Create Variables for Everything

    private EditText mFilmNameET,mProductionCompanyET,mAuthorisedAgentET,mReelFormatET,mTotalDurationET,mRHddSnoET,mRHddSizeET;


    private String mEncodingFor,mReceivedDate,mReceivedTime,mFilmName,mProductionCompany,mAuthorisedAgent,mReelFormat,mTotalDuration,mRHddSno,mRHddSize;
    private ArrayList<String> mReelWiseDuration;




    private int noOfReels=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Give ids for regular variables
         */

        mFilmNameET = findViewById(R.id.film_name_edit_text);
        mFilmName = mFilmNameET.getText().toString();

        mProductionCompanyET = findViewById(R.id.production_company_edit_text);
        mProductionCompany = mProductionCompanyET.getText().toString();

        mAuthorisedAgentET = findViewById(R.id.authorised_agent_edit_text);
        mAuthorisedAgent = mAuthorisedAgentET.getText().toString();

        mReelFormatET = findViewById(R.id.reel_format_edit_text);
        mReelFormat = mReelFormatET.getText().toString();

        mTotalDurationET = findViewById(R.id.total_duration_edit_text);
        mTotalDuration = mTotalDurationET.getText().toString();

        mRHddSnoET = findViewById(R.id.r_hdd_sn_edit_text);
        mRHddSno = mRHddSnoET.getText().toString();

        mRHddSizeET = findViewById(R.id.r_hdd_size_edit_text);
        mRHddSize = mRHddSizeET.getText().toString();


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


        //WE have to get the selected Item Text

        mEncodingFor = encodingSpinner.getSelectedItem().toString();


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



        //Let's try to get the time picker when time edit text is clicked
        EditText receivedTimeEditText = findViewById(R.id.received_time_edit_text);

        receivedTimeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openTimePicker(receivedTimeEditText);
            }
        });

        reelsLayout = findViewById(R.id.reels_linear_layout);


        //Let's get the Add reels Button, when it is clicked it should open more reels
        Button addReelBtn = findViewById(R.id.add_reel_btn);

        addReelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addReels();
            }
        });


        // Similarly when the Remove Reel Button is clicked ,it should remove a field.
        Button removeReelBtn = findViewById(R.id.remove_reel_btn);

        removeReelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                removeReels();


            }
        });





        rSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //First we have to get the text from the Reel Edit Texts

                if (noOfReels==0)
                {
                    Toast.makeText(MainActivity.this,"No Reels Added",Toast.LENGTH_SHORT).show();
                    return;
                }

                for(int i=1;i<=noOfReels;i++)
                {
                    EditText currentReelET = findViewById(i);

                    String currentReelDuration = currentReelET.getText().toString();

                    mReelWiseDuration.add(currentReelDuration);
                }

                //Now that we got the data from the reels. WE can put all of this into the Received Form


                ReceivedForm receivedForm = new ReceivedForm(mEncodingFor,mReceivedDate,mReceivedTime,mFilmName,mProductionCompany,
                        mAuthorisedAgent,mReelFormat,mTotalDuration,mRHddSno,mRHddSize,mReelWiseDuration);



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

                mReceivedDate = selectedDate;
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


        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
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

                mReceivedTime = currentTime;

                editText.setText(currentTime);


            }
        },hourOfDay,minutes,false);


        timePickerDialog.show();
    }


    /**
     * The following method is used for adding Edit Fields for Reels
     */


    public void addReels()
    {


        if (noOfReels>=12)
        {
            Toast.makeText(this,"Max no of Reels Reached",Toast.LENGTH_SHORT).show();
            return;
        }

        noOfReels++;

       EditText  reelEditText = new EditText(this);

        //We are creating this layout Params because we need to se the width and height of the edit text fields
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        reelEditText.setLayoutParams(layoutParams);

        reelEditText.setId(noOfReels);

        //Let's set the hint to the current reel number

        String currentReel = "Reel "+noOfReels;

//        reelEditText.setHint(currentReel);

        reelEditText.setText("00:00:00:00");


        reelsLayout.addView(reelEditText);







    }

    /**
     * The following method is used for removing Edit Fields for Reels
     */

    public void removeReels()
    {
        if (noOfReels<=0)
        {
            Toast.makeText(this,"No Reels Available",Toast.LENGTH_SHORT).show();

            return;
        }
        EditText removalEditText = findViewById(noOfReels);

        removalEditText.getText().clear();

        removalEditText.setVisibility(View.GONE);

        noOfReels--;
    }

}


















