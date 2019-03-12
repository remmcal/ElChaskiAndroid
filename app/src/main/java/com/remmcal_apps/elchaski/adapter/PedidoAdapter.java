package com.remmcal_apps.elchaski.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.remmcal_apps.elchaski.MainActivity;
import com.remmcal_apps.elchaski.R;
import com.remmcal_apps.elchaski.model.Pedido;
import com.remmcal_apps.elchaski.utilidades.PedidosActivity;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * Creado por Ángel Quino Chipana  en 03/enero/2019
 * dangerouslapaz@gmail.com
 * +591 78812425 - +591 68092193
 * La Paz, Bolivia
 */

public class PedidoAdapter extends RecyclerView.Adapter<PedidoAdapter.PedidoViewHolder> {

    private ArrayList<Pedido> pedidos;
    private int resource;
    private Context context;
  //  DatabaseReference pedidosRef= FirebaseDatabase.getInstance().getReference(FirebaseReferences.PEDIDOS_USUARIOS_REF);

    public PedidoAdapter(ArrayList<Pedido> pedidos, int resource, Context context) {
        this.pedidos = pedidos;
        this.resource = resource;
        this.context = context;
    }

    @Override
    public PedidoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new PedidoViewHolder(view);
    }



    @Override
    public void onBindViewHolder(PedidoViewHolder holder, int position) {
        //aquí será el paso de datos de la lista de pedidos
        Pedido pedido = pedidos.get(position    ); //obtengo el pedido actual

        holder.pedidoName.setText(pedido.getNombre());
        holder.pedidoPrice.setText(pedido.getPrecio()+" Bs");
        holder.pedidoDetails.setHint(pedido.getDetalle());
    }

    @Override
    public int getItemCount() {
        //este método devolverá u conteo de cuanots elementos tenemos
        return pedidos.size();
    }

    public class PedidoViewHolder extends RecyclerView.ViewHolder{

        private AppCompatImageButton delete;
        private TextView pedidoName,pedidoPrice;
        private EditText pedidoDetails;


        public PedidoViewHolder(View itemView) {
            super(itemView);

            pedidoName = itemView.findViewById(R.id.name);
            pedidoPrice = itemView.findViewById(R.id.price);
            pedidoDetails = itemView.findViewById(R.id.detalle);
            delete=itemView.findViewById(R.id.delete);
            delete.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onClick(View v) {
                    //eliminar el pedido actual
                    Pedido pedidoSel = pedidos.get(getAdapterPosition());
                    pedidos.remove(pedidoSel);
                }
            });
        }
    }
}

