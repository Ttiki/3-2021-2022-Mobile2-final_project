package com.ttiki.ccapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.ttiki.ccapp.databinding.ActivityCarDetailBinding;
import com.ttiki.ccapp.model.CaracterDetail;
import com.ttiki.ccapp.network.ICarAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CarDetail extends AppCompatActivity {
    ActivityCarDetailBinding ui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("TESTING THIRD VIEW IS LOADING!");

        ui = ActivityCarDetailBinding.inflate(getLayoutInflater());

        Intent i = getIntent();

        int id = i.getIntExtra("id", -1);

        Log.d("Log", "Character's id : " + id);
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://623b4baf2e056d1037f07a74.mockapi.io/")
                .build();
        ICarAPI service = retrofit.create(ICarAPI.class);
        Call<List<CaracterDetail>> caractersCall = service.getCharacterById(id);

        caractersCall.enqueue(new Callback<List<CaracterDetail>>() {
            @Override
            public void onResponse(Call<List<CaracterDetail>> call, Response<List<CaracterDetail>> response) {
                CaracterDetail cd = response.body().get(0);

                Log.d("Log", cd.getName() + " has been selected. Here's its information");

                Glide.with(ui.getRoot()).load(cd.getImage()).into(ui.carImg);
                ui.name.setText(cd.getName());
                ui.isAlive.setText(Boolean.toString(cd.isAlive()));

                if (cd.isAlive()) {
                    ui.isAlive.setTextColor(Color.parseColor("#43a047"));
                } else {
                    ui.isAlive.setTextColor(Color.parseColor("#ba2126"));
                }
            }

            @Override
            public void onFailure(Call<List<CaracterDetail>> call, Throwable t) {
                Log.d("Log", "ERROR! COULDN'T RETRIEVE DATA FROM API!!!");
                System.out.println("> Call : " + call);
                System.out.println("> Throwable : " + t);
            }
        });

        setContentView(R.layout.activity_car_detail);
    }
}