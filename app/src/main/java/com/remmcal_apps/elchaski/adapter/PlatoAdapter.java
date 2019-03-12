package com.remmcal_apps.elchaski.adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.remmcal_apps.elchaski.MainActivity;
import com.remmcal_apps.elchaski.R;
import com.remmcal_apps.elchaski.model.Pedido;
import com.remmcal_apps.elchaski.model.Plato;
import com.remmcal_apps.elchaski.model.Product;


import java.util.ArrayList;
import java.util.List;


/**
 * Creado por Ángel Quino Chipana  en 31/diciembre/2018
 * dangerouslapaz@gmail.com
 * +591 78812425 - +591 68092193
 * La Paz, Bolivia
 */
public class PlatoAdapter extends RecyclerView.Adapter<PlatoAdapter.PlatoViewHolder> {

    private ArrayList<Plato> products;

    public ArrayList<String> CodPedidos = new ArrayList<>();

    public PlatoAdapter(ArrayList<Plato> products) {
        this.products = products;

    }

    @Override
    public PlatoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.plato_item, parent,false);
        return new PlatoViewHolder(view);
    }


    public void onBindViewHolder(PlatoViewHolder holder, int position) {
        Plato plato = products.get(position);



        holder.tvId.setText(plato.getId());
        holder.tvRestaurante.setText(plato.getRestaurante());
        holder.tvNombre.setText(plato.getNombre());
        holder.tvDescripcion.setText(plato.getDescripcion());
        holder.tvPrecio.setText(plato.getPrecio()+" Bs.");
        holder.tvImagen.setImageResource(plato.getImagen());


        //action buttons
        holder.setOnClickListener(this);

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class PlatoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //Extraer datos
        Context context;


        TextView tvId;
        TextView tvRestaurante;
        TextView tvNombre;
        TextView tvDescripcion;
        TextView tvPrecio;
        ImageView tvImagen;
        //Botones
        ImageButton btnAddPlato;


        public PlatoViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            //aqui deberia estar la posicion



            tvId = (TextView) itemView.findViewById(R.id.tv_id);
            tvRestaurante = (TextView) itemView.findViewById(R.id.tv_restaurante);
            tvNombre= (TextView) itemView.findViewById(R.id.name);
            tvDescripcion= (TextView) itemView.findViewById(R.id.tv_descripcion);
            tvPrecio= (TextView) itemView.findViewById(R.id.price);
            tvImagen= (ImageView) itemView.findViewById(R.id.photo);

            btnAddPlato= (ImageButton) itemView.findViewById(R.id.btn_addPedido);

        }
        void setOnClickListener(PlatoAdapter platoAdapter){
            btnAddPlato.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // si son 2 botones hacer un switch
            //se puede usar direcctamente los atributos
            CodPedidos.add((String) tvId.getText());
            String datos = tvNombre.getText() +"  AGREGADO AL CARRITO";
            Toast.makeText(context,datos, Toast.LENGTH_SHORT).show();

        }
    }



    public ArrayList<String> getPedidos()
    {
        return  CodPedidos;
    }
}


   /* }
    public void setFilter(ArrayList<Product> products){
        this.products =new ArrayList<>();
        this.products.addAll(products);
        notifyDataSetChanged();
    }
    private String getDetalle(){
        return "Todo por defecto";
    }
    private String getOpcionales(){
        return "Todo por defecto";
    }
    private String getFechaHoy(){
        Calendar now = Calendar.getInstance();
        String hoy=(now.get(Calendar.DAY_OF_MONTH)+"/"+now.get(Calendar.MONTH)+"/"+now.get(Calendar.YEAR));
        String[] parts = hoy.split("/");
        String dia = parts[0];
        String mes = parts[1];
        int mesReal= Integer.parseInt(mes)+1;
        mes=mesReal+"";
        String anho= parts[2];
        if(Integer.parseInt(dia)<10){
            dia="0"+dia;
        }
        if(Integer.parseInt(mes)<10){
            mes="0"+mes;
        }
        hoy=dia+"/"+mes+"/"+anho;
        return hoy;
    }*/