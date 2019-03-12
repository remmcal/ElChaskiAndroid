package com.remmcal_apps.elchaski.utilidades;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.remmcal_apps.elchaski.R;
import com.remmcal_apps.elchaski.adapter.PedidoAdapter;
import com.remmcal_apps.elchaski.model.Pedido;

import java.util.ArrayList;

public class PedidosActivity extends AppCompatActivity{
    ActionBar ab;
    Toolbar toolbar;
    RecyclerView pedidosRecycler;
    ArrayList<Pedido> pedidos=new ArrayList<>();
    GridLayoutManager mLayoutManager;
    PedidoAdapter pedidoAdapter;
    //DatabaseReference pedidosRef= FirebaseDatabase.getInstance().getReference(FirebaseReferences.PEDIDOS_USUARIOS_REF);
    AppBarLayout appBarLayout;
    AppCompatTextView cantPed,costoEnvio,costoTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);
        enlaceUI();
        pedidosRecycler.setHasFixedSize(true);
        mLayoutManager=new GridLayoutManager(this,1);
        pedidosRecycler.setItemAnimator(new DefaultItemAnimator());
        pedidosRecycler.setLayoutManager(mLayoutManager);
        pedidoAdapter=new PedidoAdapter(pedidos,R.layout.pedido_item,this);
        pedidosRecycler.setAdapter(pedidoAdapter);
        //pedidosRef.child(FirebaseAuth.getInstance().getUid()).addValueEventListener(new ValueEventListener() {
          /*  @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                pedidos.removeAll(pedidos);
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    try {
                        Pedido pedido = snapshot.getValue(Pedido.class);
                        pedidos.add(pedido);
                    }catch (Exception e){

                    }

                }
                total(pedidos);
                pedidoAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset <= -appBarLayout.getTotalScrollRange() + toolbar.getHeight()) {
                    //Toolbar Collapsed
                    toolbar.setTitle("5 Productos");
                    toolbar.setSubtitle("Total 50.24 Bs");
                } else {
                    //Toolbar Expanded
                    toolbar.setTitle("");
                    toolbar.setSubtitle("");
                    /*Imaginaos que el parpadeo en el snackBar se debía a que por else seteaba " " jajajaja
                     * Casi considero incluir el title para no tener ese parpadeo en el snackBar */
                }
            }
        });

    }
    public void enlaceUI(){
        appBarLayout = findViewById(R.id.app_bar);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //setTitle("Mis Pedidos");
        ab=getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        //toolbar.setNavigationIcon(R.drawable.perfil);
        pedidosRecycler=findViewById(R.id.pedidosRecycler);
        cantPed=findViewById(R.id.cantidad);
        costoEnvio=findViewById(R.id.costoEnvio);
        costoTotal=findViewById(R.id.costoTotal);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Pedido>filter(ArrayList<Pedido> pedidos, String texto){
        ArrayList<Pedido> listaFiltrada=new ArrayList<>();
        try {
            texto=texto.toLowerCase();
            for(Pedido pedidoi:pedidos){
                String textoTotal=pedidoi.getNombre().toLowerCase();
                if(textoTotal.contains(texto)){//si el texto introducido al buscador esta en notaoObten da true
                    listaFiltrada.add(pedidoi);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaFiltrada;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_pedido,menu);
        return true;
    }

    public void total(ArrayList<Pedido> pedidos){
        int cant=0;
        double envio=0;
        double total=0;
        for(int i=0;i<pedidos.size();i++){
            Pedido pedido = pedidos.get(i);
            cant++;
            envio++;
            total=total+pedido.getPrecio();
        }
        cantPed.setText(cant+" Productos");
        costoEnvio.setText(envio+" Bs");
        costoTotal.setText(total+" Bs");
    }
}
