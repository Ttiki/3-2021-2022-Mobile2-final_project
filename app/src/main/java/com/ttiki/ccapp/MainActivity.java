package com.ttiki.ccapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ttiki.ccapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding ui;
    Button seeListBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ui = ActivityMainBinding.inflate(getLayoutInflater());

        seeListBtn = findViewById(R.id.listCarBtn);

        seeListBtn.setOnClickListener(e -> {
            Intent i = new Intent(MainActivity.this, ListCar.class);
            startActivity(i);
        });
    }
}