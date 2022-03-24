package com.ttiki.ccapp.viewholder;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ttiki.ccapp.adapter.CaracterAdapter;
import com.ttiki.ccapp.databinding.CaracterItemBinding;
import com.ttiki.ccapp.model.Caracter;

public class CaracterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final CaracterItemBinding ui;
    private CaracterAdapter.OnItemClickListener listener;

    public CaracterViewHolder(CaracterItemBinding ui) {
        super(ui.getRoot());
        this.ui = ui;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("Log", "itemClicked");
        if ((listener != null)) {
            this.listener.onItemClick(getAdapterPosition());
        }
    }

    public void setOnItemClickListener(CaracterAdapter.OnItemClickListener i) {
        this.listener = i;
    }

    public void setCaracter(Caracter caracter) {
        ui.carName.setText(caracter.getName());
        ui.carType.setText(String.valueOf(caracter.getSpecies()));
        ui.carIsAlive.setText(String.valueOf(caracter.isAlive()));

        Glide.with(ui.getRoot()).load(caracter.getImage()).into(ui.carImgView);

    }

}
