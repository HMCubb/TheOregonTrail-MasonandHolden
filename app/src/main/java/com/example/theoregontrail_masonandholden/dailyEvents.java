package com.example.theoregontrail_masonandholden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class dailyEvents extends AppCompatActivity {

    public RandomEvents newRandomEvents;
    public dailyEvents(){}

    public dailyEvents(RandomEvents newRandomEvents){
        this.newRandomEvents = newRandomEvents;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_events);

        newRandomEvents = (RandomEvents) getIntent().getSerializableExtra("NewRandomEvents");

        EditText eventText = findViewById(R.id.eventText);
        eventText.setText(String.valueOf(newRandomEvents.lostMember));

        configureNextButton();
    }

    private void configureNextButton() {


        Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_daily_status);
                startActivity(new Intent(dailyEvents.this, DailyStatus.class));
            }
        });
    }

}