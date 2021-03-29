package com.fsemicolon.veloxcms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

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


        rSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this,DispatchActivity.class);

                startActivity(intent);
            }
        });
    }
}