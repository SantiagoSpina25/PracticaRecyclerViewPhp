package com.example.campeonesrviewjson;

import android.os.Bundle;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private RequestQueue queue;
    private ItemAdapter adapter; // Agregar la referencia del adaptador
    private ArrayList<Campeon> datos; // Lista para almacenar los campeones

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar la lista de campeones
        datos = new ArrayList<>();

        // Inicializar el adaptador con la lista vacía
        adapter = new ItemAdapter(datos);

        // Configurar el RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);  // Asignar el adaptador al RecyclerView

        // Animación de los elementos del RecyclerView
        int resId = R.anim.layout_animation_fall_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(recyclerView.getContext(), resId);
        recyclerView.setLayoutAnimation(animation);

        // Llamar al método para obtener los datos de la API
        obtenerDatos();
    }

    private void obtenerDatos(){
        // Asegúrate de que se esté creando una nueva cola de solicitudes
        queue = Volley.newRequestQueue(this);
        String url = "http://10.192.240.57/campeones/obtenerTodosCampeones.php"; // Usa la IP correcta aquí

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("VolleyResponse", "Respuesta recibida: " + response.toString()); // Este es el log que debe aparecer
                        try {
                            JSONArray datosCampeones = response.getJSONObject(0).getJSONArray("mensaje");
                            // Procesar los datos obtenidos
                            for (int i = 0; i < datosCampeones.length(); i++) {
                                JSONObject objcampeon = datosCampeones.getJSONObject(i);

                                int id = objcampeon.getInt("ID");
                                String nombre = objcampeon.getString("nombre");
                                int fechaMundialGanado = objcampeon.getInt("fechaMundialGanado");

                                Campeon campeon = new Campeon(id, nombre, fechaMundialGanado);
                                datos.add(campeon);  // Agregar el nuevo campeón a la lista

                            }
                            System.out.println(datos);
                            // Notificar al adaptador que los datos han cambiado
                            adapter.notifyDataSetChanged();  // Actualiza el adaptador con los nuevos datos

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("VolleyError", "Error al obtener los datos: " + error.toString()); // Log para errores
                    }
                });

        queue.add(jsonObjectRequest);  // Asegúrate de añadir la solicitud a la cola
    }
}
