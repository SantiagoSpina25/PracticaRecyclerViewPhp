package com.example.campeonesrviewjson;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private ArrayList<Campeon> campeones;

    // Constructor para pasar la lista de campeones
    public ItemAdapter(ArrayList<Campeon> campeones) {
        this.campeones = campeones;
    }

    // Se infla el layout de cada ítem del RecyclerView
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    // Aquí se asignan los valores de cada campo del campeon al layout
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Campeon campeon = campeones.get(position);
        holder.txtArticulo.setText(campeon.getNombreCampeon());
        holder.txtFecha.setText(String.valueOf(campeon.getFechaMundial()));
    }

    // Devuelve el tamaño de la lista
    @Override
    public int getItemCount() {
        return campeones.size();
    }

    // Clase ViewHolder para el diseño de cada ítem
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtArticulo;
        TextView txtFecha;

        public ViewHolder(View itemView) {
            super(itemView);
            txtArticulo = itemView.findViewById(R.id.txtArticulo);  // Asegúrate de que el ID esté correcto
            txtFecha = itemView.findViewById(R.id.txtFecha);  // Asegúrate de que el ID esté correcto
        }
    }
}

