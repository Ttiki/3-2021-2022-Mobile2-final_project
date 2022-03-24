package com.ttiki.ccapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ttiki.ccapp.adapter.CaracterAdapter;
import com.ttiki.ccapp.model.Caracter;
import com.ttiki.ccapp.network.ICarAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListCar extends AppCompatActivity {

    // Main API uri
    RecyclerView rv;

    ArrayList<Caracter> caracters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_car);

        Intent i = getIntent();

        rv = findViewById(R.id.carRV);

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://623b4baf2e056d1037f07a74.mockapi.io/")
                .build();

        ICarAPI service = retrofit.create(ICarAPI.class);
        Call<List<Caracter>> caractersCall = service.getAllCaracters();
        caractersCall.enqueue(new Callback<List<Caracter>>() {
            @Override
            public void onResponse(Call<List<Caracter>> call, Response<List<Caracter>> response) {
                System.out.println("TESTING!");
                LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
                rv.setLayoutManager(llm);
                caracters = new ArrayList(response.body());
                CaracterAdapter ca = new CaracterAdapter(caracters);
                Log.d("log", caracters.get(0).getName());
                ca.setOnItemClickListener(position -> {
                    Log.d("Log", "Caracter " + caracters.get(position).getName() + " clicked");
                    Intent detail = new Intent(getApplicationContext(), CarDetail.class);
                    detail.putExtra("id", caracters.get(position).getId());
                    startActivity(detail);
                });
                rv.setAdapter(ca);
            }

            @Override
            public void onFailure(Call<List<Caracter>> call, Throwable t) {
                Log.d("Log", "ERROR! COULDN'T RETRIEVE DATA FROM API!!!");
                System.out.println("> Call : " + call);
                System.out.println("> Throwable : " + t);
            }
        });


    }
}