package com.example.theoregontrail_masonandholden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LocationPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_page);

        configureMapButton();
        configureResourcesButton();
        configurePartyButton();
        configureShopButton();
        configureNextLocationButton();
    }

    private void configureMapButton() {

        Button continueButton = (Button) findViewById(R.id.mapButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void configureResourcesButton() {

        Button continueButton = (Button) findViewById(R.id.resourcesButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void configurePartyButton() {

        Button continueButton = (Button) findViewById(R.id.partyButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void configureShopButton() {

        Button continueButton = (Button) findViewById(R.id.shopButton);
        continueButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                setContentView(R.layout.activity_store);
                startActivity(new Intent(LocationPage.this, Store.class));
            }
        });
    }

    private void configureNextLocationButton() {

        Button continueButton = (Button) findViewById(R.id.nextButtonLocationButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}