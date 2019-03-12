package com.remmcal_apps.elchaski;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.remmcal_apps.elchaski.adapter.PlatoAdapter;
import com.remmcal_apps.elchaski.adapter.RestaurantAdapter;
import com.remmcal_apps.elchaski.model.Plato;
import com.remmcal_apps.elchaski.model.Restaurant;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvRestaurant;
    private LinearLayoutManager lmRestaurant;
    private RestaurantAdapter adapterRestaurant;


    private FloatingActionButton fabPedidos;


    //pedidos
    private  ArrayList<String> CodPedidos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rvRestaurant = (RecyclerView) findViewById(R.id.rv_reataurante);
        rvRestaurant.setHasFixedSize(true);

        lmRestaurant= new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvRestaurant.setLayoutManager(lmRestaurant);
        rvRestaurant.setNestedScrollingEnabled(false);
        adapterRestaurant= new RestaurantAdapter(dataSetRestaurantes(), R.layout.restaurant_item, this);
        rvRestaurant.setAdapter(adapterRestaurant);




        fabPedidos = (FloatingActionButton) findViewById(R.id.fab_compras);
        fabPedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PedidosActivity.class);
               CodPedidos = adapterRestaurant.getPedidos();
               i.putExtra("datos", CodPedidos);
               startActivity(i);
            }
        });

    }

    private ArrayList<Restaurant> dataSetRestaurantes() {

        ArrayList<Restaurant> dataRestaurantes = new ArrayList<>();
        dataRestaurantes.add(new Restaurant("res01", "Snack Rosita", "rosita", "11:00 - 21:30",
                "Comida rápida", false));
        dataRestaurantes.add(new Restaurant("res02", "Ollita de Barro", "rosita", "11:00 - 21:30",
                "Comida rápida", false));
        dataRestaurantes.add(new Restaurant("res03", "Pizzas Nápoles", "rosita", "11:00 - 21:30",
                "Comida rápida", false));
        dataRestaurantes.add(new Restaurant("res04", "Fritodo", "rosita", "11:00 - 21:30",
                "Comida rápida", false));
        return dataRestaurantes;}


}
