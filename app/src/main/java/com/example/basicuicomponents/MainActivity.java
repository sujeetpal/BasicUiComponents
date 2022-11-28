package com.example.basicuicomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    Button send_button;
    EditText name;
    DatePicker picker;
    RadioButton genderradioButton;
    RadioGroup radioGroup;
    CheckBox aiml, web, mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send_button = findViewById(R.id.send_button_id);
        name = findViewById(R.id.name);
        picker=(DatePicker)findViewById(R.id.dp);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);

        aiml=(CheckBox)findViewById(R.id.aiml);
        web=(CheckBox)findViewById(R.id.web);
        mobile=(CheckBox)findViewById(R.id.mobile);

        // add the OnClickListener in sender button after clicked this button following Instruction will run
        send_button.setOnClickListener(v -> {
            // get the value which input by user in EditText and convert it to string
            String str = name.getText().toString();
            int selectedId = radioGroup.getCheckedRadioButtonId();
            genderradioButton = (RadioButton) findViewById(selectedId);

            String result = "";

            if(aiml.isChecked())
                result = result + "AIML";
            if(web.isChecked())
                result = result +  " Web";

            if(mobile.isChecked())
                result = result +  " Mobile";

            // Create the Intent object of this class Context() to Second_activity class
            Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);


            // now by putExtra method put the value in key, value pair key is
            // message_key by this key we will receive the value, and put the string
            intent.putExtra("message_name", str);
            intent.putExtra("message_date",getCurrentDate());
            intent.putExtra("message_gender", genderradioButton.getText());
            intent.putExtra("message_interests", result);
            // start the Intent
            startActivity(intent);
        });
    }

    public String getCurrentDate(){
        StringBuilder builder=new StringBuilder();;
        builder.append((picker.getMonth() + 1)+"/");//month is 0 based
        builder.append(picker.getDayOfMonth()+"/");
        builder.append(picker.getYear());
        return builder.toString();
    }
}