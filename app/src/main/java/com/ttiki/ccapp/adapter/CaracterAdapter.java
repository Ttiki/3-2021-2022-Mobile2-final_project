package com.ttiki.ccapp.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ttiki.ccapp.databinding.CaracterItemBinding;
import com.ttiki.ccapp.model.Caracter;
import com.ttiki.ccapp.viewholder.CaracterViewHolder;

import java.util.ArrayList;

public class CaracterAdapter extends RecyclerView.Adapter<CaracterViewHolder> {
    ArrayList<Caracter> caracters;
    OnItemClickListener listener;

    public CaracterAdapter(ArrayList<Caracter> caracters) {
        Log.d("Log", "ADAPTER IS BINDING...");
        this.caracters = caracters;
    }


    public ArrayList<Caracter> getCaracters() {
        return caracters;
    }

    public void setCaracters(ArrayList<Caracter> caracters) {
        this.caracters = caracters;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CaracterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("Log", "CREATING VIEW HOLDER!");
        CaracterItemBinding ui = CaracterItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CaracterViewHolder(ui);
    }

    @Override
    public void onBindViewHolder(@NonNull CaracterViewHolder holder, int position) {
        Log.d("Log", "BINDING VIEW HOLDER!");
        Caracter car = caracters.get(position);
        holder.setCaracter(car);
        holder.setOnItemClickListener(this.listener);
    }

    @Override
    public int getItemCount() {
        return caracters.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int postition);
    }
}
