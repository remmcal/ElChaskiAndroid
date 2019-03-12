package com.remmcal_apps.elchaski.adapter;

import android.content.Context;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.remmcal_apps.elchaski.R;
import com.remmcal_apps.elchaski.model.Plato;
import com.remmcal_apps.elchaski.model.Restaurant;
import java.util.ArrayList;

/**
 * Creado por Ángel Quino Chipana  en 16/noviembre/2018
 * dangerouslapaz@gmail.com
 * +591 78812425 - +591 68092193
 * La Paz, Bolivia
 */
public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {

    private ArrayList<Restaurant> restaurants;
    private int resource;
    private Context context;

    //pedidos
    public ArrayList<String> CodPedidos = new ArrayList<>();

    public RestaurantAdapter(ArrayList<Restaurant> restaurants, int resource, Context context) {
        this.restaurants = restaurants;
        this.resource = resource;
        this.context = context;
    }

    @Override
    public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new RestaurantViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final RestaurantViewHolder holder, final int position) {

        Restaurant restaurant = restaurants.get(position);
        /*
        Glide.with(context)
                .load(restaurant.getPhoto())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.restaurantPhoto);*/
        holder.restaurantName.setText(restaurant.getName());
        holder.restaurantType.setText(restaurant.getType());
        if(restaurant.isState()) {
            holder.restaurantState.setText("Abierto");
            holder.restaurantState.setTextColor(context.getResources().getColor(R.color.green));
            holder.restaurantState.setBackground(context.getResources().getDrawable(R.drawable.horary_open));
        }
        else {
            holder.restaurantState.setText("Cerrado");
            holder.restaurantState.setTextColor(context.getResources().getColor(R.color.red));
            //holder.restaurantState.setBackground(context.getResources().getDrawable(R.drawable.horary_close));
        }

        holder.platosRecycler.setHasFixedSize(true);
        holder.mLayoutManager=new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false);
        holder.platosRecycler.setItemAnimator(new DefaultItemAnimator());
        holder.platosRecycler.setLayoutManager(holder.mLayoutManager);

        ArrayList<Plato> data= new ArrayList<>();

        switch(position){

            case 0:     data= dataSetSnackRosita();
                break;
            case 1:     data= dataSetOllitaDeBarro();
                break;
            case 2:     data= dataSetPizzasNapoles();
                break;
            case 3:     data= dataSetFritodo();
                break;
        }

        holder.platoAdapter=new PlatoAdapter(data);

        CodPedidos.addAll(holder.platoAdapter.getPedidos());// agregando todos los objetos de esa lista
        System.out.print(CodPedidos);
        holder.platosRecycler.setAdapter(holder.platoAdapter);

    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder{
        private TextView restaurantName,restaurantType,restaurantState;
        RecyclerView platosRecycler;
        LinearLayoutManager mLayoutManager;
        PlatoAdapter platoAdapter;
        public RestaurantViewHolder(View itemView) {
            super(itemView);
            restaurantName= itemView.findViewById(R.id.name);
            restaurantType= itemView.findViewById(R.id.type);
            restaurantState=itemView.findViewById(R.id.state);
            platosRecycler=itemView.findViewById(R.id.platosRecycler);


       //     CodPedidos = platoAdapter.getPedidos();
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Restaurant restaurantSel = restaurants.get(getAdapterPosition());
                    Intent intent = new Intent(context, RestaurantActivity.class);
                    intent.putExtra("restaurantSel", restaurantSel);
                    context.startActivity(intent);
                }
            });*/
        }

    }
    public void setFilter(ArrayList<Restaurant> restaurants){
        this.restaurants =new ArrayList<>();
        this.restaurants.addAll(restaurants);
        notifyDataSetChanged();
    }


    public ArrayList<String> getPedidos()
    {
        return CodPedidos;
    }




    private ArrayList<Plato> dataSetSnackRosita() {

        ArrayList<Plato> dataSnackRosita = new ArrayList<>();
        dataSnackRosita.add(new Plato("sr01", "Snack Rosita", "Pollo Económico", "Tallarin, papa y postre", 11, R.drawable.pollo11));
        dataSnackRosita.add(new Plato("sr02", "Snack Rosita", "Pierna y entrepierna", "Tallarin, papa y postre", 15, R.drawable.pollo15));
        dataSnackRosita.add(new Plato("sr03", "Snack Rosita", "Ala y pecho", "Tallarin, papa y postre", 19, R.drawable.pollo19));
        dataSnackRosita.add(new Plato("sr04", "Snack Rosita", "Medio pollo", "Tallarin, papa y postre", 30, R.drawable.pollos));
        dataSnackRosita.add(new Plato("sr05", "Snack Rosita", "Pollo entero", "Tallarin, papa y postre", 60, R.drawable.pollos));
        return dataSnackRosita;}

    private ArrayList<Plato> dataSetOllitaDeBarro() {

        ArrayList<Plato> dataOllitaDeBarro = new ArrayList<>();
        dataOllitaDeBarro.add(new Plato("ob01", "Ollita de Barro", "Chairo", "Tallarin, papa y postre", 7, R.drawable.ollita1));
        dataOllitaDeBarro.add(new Plato("ob02", "Ollita de Barro", "Costilla de Cordero", "Tallarin, papa y postre", 18, R.drawable.ollita2));
        dataOllitaDeBarro.add(new Plato("ob03", "Ollita de Barro", "Sajta", "Tallarin, papa y postre", 15, R.drawable.ollita3));
        dataOllitaDeBarro.add(new Plato("ob04", "Ollita de Barro", "Saice", "Tallarin, papa y postre", 33, R.drawable.ollita4));
        dataOllitaDeBarro.add(new Plato("ob05", "Ollita de Barro", "Milanesa", "Tallarin, papa y postre", 10, R.drawable.ollita6));
        return dataOllitaDeBarro;}

    private ArrayList<Plato> dataSetPizzasNapoles() {

        ArrayList<Plato> dataPizzasNapoles = new ArrayList<>();
        dataPizzasNapoles.add(new Plato("pn01", "Pizzas Nápoles", "Pequeña 25cm", "Tallarin, papa y postre", 23, R.drawable.napoles1));
        dataPizzasNapoles.add(new Plato("pn02", "Pizzas Nápoles", "Mediana 30cm", "Tallarin, papa y postre", 30, R.drawable.napoles2));
        dataPizzasNapoles.add(new Plato("pn03", "Pizzas Nápoles", "Grande 40cm", "Tallarin, papa y postre", 35, R.drawable.napoles3));
        dataPizzasNapoles.add(new Plato("pn04", "Pizzas Nápoles", "Familiar 45cm", "Tallarin, papa y postre", 45, R.drawable.napoles4));
        dataPizzasNapoles.add(new Plato("pn05", "Pizzas Nápoles", "Súper 50cm", "Tallarin, papa y postre", 60, R.drawable.napoles5));
        return dataPizzasNapoles;}

    private ArrayList<Plato> dataSetFritodo() {

        ArrayList<Plato> dataFritodo = new ArrayList<>();
        dataFritodo.add(new Plato("ft01", "Snack Fritodo", "Salchipapa", "Tallarin, papa y postre", 5, R.drawable.fritodo1));
        dataFritodo.add(new Plato("ft02", "Snack Fritodo", "Hamburguesa", "Tallarin, papa y postre", 4, R.drawable.fritodo2));
        dataFritodo.add(new Plato("ft03", "Snack Fritodo", "Hot Dog", "Tallarin, papa y postre", 4, R.drawable.fritodo3));
        dataFritodo.add(new Plato("ft04", "Snack Fritodo", "Porcioón de Papas", "Tallarin, papa y postre", 4, R.drawable.fritodo4));
        return dataFritodo;}

}
