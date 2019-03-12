package com.remmcal_apps.elchaski;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.remmcal_apps.elchaski.adapter.PedidoAdapter;
import com.remmcal_apps.elchaski.model.Pedido;
import com.remmcal_apps.elchaski.utilidades.FirebaseReferences;

import java.util.ArrayList;


public class PedidosActivity extends AppCompatActivity {
    ActionBar ab;
    Toolbar toolbar;
    RecyclerView pedidosRecycler;
    PedidoAdapter pedidosAdapter;
    ArrayList<Pedido> pedidos = new ArrayList<>();
    LinearLayoutManager mLayoutManager;
    AppBarLayout appBarLayout;
    AppCompatTextView cantPed, costProd, costEnv, costTot;

    String StringPedidoTotal = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        pedidosRecycler = (RecyclerView) findViewById(R.id.pedidosRecycler);

        mLayoutManager= new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        pedidosRecycler.setLayoutManager(mLayoutManager);
        pedidosRecycler.setNestedScrollingEnabled(false);
        pedidosAdapter= new PedidoAdapter(dataPedidos(),R.layout.pedido_item, this);
        pedidosRecycler.setAdapter(pedidosAdapter);


         cantPed = (AppCompatTextView) findViewById(R.id.cantidad); // nro + Productos
         costProd = (AppCompatTextView) findViewById(R.id.costoProductos); // nro + Bs.
         costEnv = (AppCompatTextView) findViewById(R.id.costoEnvio); // nro + Bs.
         costTot = (AppCompatTextView) findViewById(R.id.costoTotal); // nro + Bs.
         ModificarDatos();



    //    TextView tvpedidos = (TextView) findViewById(R.id.tv_pe);

  //   ArrayList <String> datos = getIntent().getExtras().getStringArrayList("datos");


   /*    String data = "";

        for (int i=0; i<datos.size();i++)
        {


            tvpedidos.setText(data);       data = data+" "+datos.get(i);
        }

*/

    }

    private void ModificarDatos() {
        cantPed.setText(dataPedidos().size()+" Productos");
        double ce=0,cp=0;
        for (int i=0; i<dataPedidos().size();i++)
        {
                Pedido p= dataPedidos().get(i);
                ce=ce+p.getPrecioEnvio();
                cp=cp+p.getPrecio();

        }

        costEnv.setText(ce+" Bs.");
        costProd.setText(cp+" Bs.");
        double ct=ce+cp;
        costTot.setText(ct+" Bs.");
    }


    public ArrayList<Pedido> dataPedidos()
    {
        //deberiamos obtener el detalle vacío para poner sugerencias

        pedidos= new ArrayList<>();
        pedidos.add(new Pedido("sr01", "Snack Rosita", "Pollo Económio", "arroz o fideo",11.00, 1));
        pedidos.add(new Pedido("sr01", "Snack Rosita", "Pollo Económio", "6 porciones",11.00, 1));
        pedidos.add(new Pedido("sr01", "Snack Rosita", "Pollo Económio", "llajua o escabeche",11.00, 1));
        pedidos.add(new Pedido("sr01", "Snack Rosita", "Pollo Económio", "tallarin ",11.00, 1));

        return  pedidos;
    }

    public void enviar(View view) {

        PackageManager pm=getPackageManager();
        try {

            Intent waIntent = new Intent(Intent.ACTION_SEND);
            waIntent.setType("text/plain");
            String text = "YOUR TEXT HERE";

            PackageInfo info=pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
            //Check if package exists or not. If not then code
            //in catch block will be called
            waIntent.setPackage("com.whatsapp");

            waIntent.putExtra(Intent.EXTRA_TEXT, text);
            startActivity(Intent.createChooser(waIntent, "Share with"));

        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(this, "WhatsApp not Installed", Toast.LENGTH_SHORT)
                    .show();
        }

    }
    //ultimo click enviar a whatsapp
   /* public void enviar (View v){

        StringPedidoTotal = FormatearPedidoTotal();

        // PackageManager pm=getPackageManager();
        try {

            Uri uri = Uri.parse("smsto:+59177711442" );

            Intent i = new Intent(Intent.ACTION_SENDTO, uri);
            i.setPackage("com.whatsapp");
            startActivity(Intent.createChooser(i, StringPedidoTotal));

        } catch (Exception e) {
            Toast.makeText(this, "WhatsApp not Installed", Toast.LENGTH_SHORT)
                    .show();
        }

    }
*/
    public String FormatearPedidoTotal()
    {
        String ped="CANTIDAD DE PEDIDOS: "+pedidos.size()+"/n";
        Pedido p;
        double ce=0,cp=0,ct=0;
        for (int i=0; i< pedidos.size();i++)
        {
            p= pedidos.get(i);

            ped = ped+p.getNombre()+" "+p.getDetalle()+"/n";
            /*switch (p.getId()){
                case "sr*":  ped=ped+" "+p.getNombre();
                    break;
                case "ob*":  ped=ped+" "+p.getNombre();
                    break;
                case "pn*":  ped=ped+" "+p.getNombre();
                    break;
                case "ft*":  ped=ped+" "+p.getNombre();
                    break;
                */
            ce=ce+p.getPrecioEnvio();
            cp=cp+p.getPrecio();
            }

            ct=ce+cp;
            ped=ped+"Costo de Envío: "+ce +" Bs. /n";
            ped=ped+"Costo de productos: "+cp+"Bs. /n";
            ped=ped+"Costo Total: "+ct+" Bs.";

            return ped;
        }

    }

