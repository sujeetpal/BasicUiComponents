package com.example.basicuicomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    TextView name, gender, interests, dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        name = findViewById(R.id.received_value_name);
        gender = findViewById(R.id.received_value_gender);
        interests = findViewById(R.id.received_value_interests);
        dob = findViewById(R.id.received_value_dob);

        // create the get Intent object
        Intent intent = getIntent();
        String str;
        // receive the value by getStringExtra() method and
        // key must be same which is send by first activity
        str = "Name: " + intent.getStringExtra("message_name");
        name.setText(str);

        str = "Gender: " + intent.getStringExtra("message_gender");
        gender.setText(str);

        str = "Interests: " + intent.getStringExtra("message_interests");
        interests.setText(str);

        str =  "Date of Birth: " + intent.getStringExtra("message_date");
        dob.setText(str);


        // display the string into textView

    }
}