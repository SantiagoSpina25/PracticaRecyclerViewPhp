package com.example.campeonesrviewjson;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DescripcionItem extends Activity {
    Button btnAtras;
    ImageView imgvDescArticulo;
    TextView txtDesc, txtFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_item);

        btnAtras = findViewById(R.id.btnAtras);
        imgvDescArticulo = findViewById(R.id.imgvDescArticulo);
        txtDesc = findViewById(R.id.txtDesc);
        txtFecha = findViewById(R.id.txtFecha);

        // Recupera el dato de la imagen y del texto del Intent
        int imagenCampeon = getIntent().getIntExtra("imagenCampeon",0);
        String nombreCampeon = getIntent().getStringExtra("nombreCampeon");
        String fechaMundial = getIntent().getStringExtra("fechaMundial");

        imgvDescArticulo.setImageResource(imagenCampeon);
        txtDesc.setText(nombreCampeon);
        txtFecha.setText(fechaMundial);

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anteriorActivity = new Intent(view.getContext(), MainActivity.class);
                startActivity(anteriorActivity);
            }
        });
    }

}
