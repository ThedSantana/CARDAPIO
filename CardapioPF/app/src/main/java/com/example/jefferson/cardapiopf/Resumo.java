package com.example.jefferson.cardapiopf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Resumo extends ActionBarActivity {
    ArrayList<String>listaPratos = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resumo);

        Intent intent = getIntent();
        if(intent != null){
            Bundle params = intent.getExtras();
            if(params != null){
                String bebidas = params.getString("beb");
                String prato = params.getString("prato");
                String total = params.getString("c");

                TextView resPratos = (TextView) findViewById(R.id.txt_res_pratos);
                TextView resTotal = (TextView) findViewById(R.id.txt_res_total);
                TextView resBebi = (TextView) findViewById(R.id.txt_res_beb);
                String pf;


                if(PratoFeito.totPrato2.equals("")){
                    resPratos.setText("PORÇÕES:"+ "\n"+SelfService.opcoes2);
                }else {
                    resPratos.setText("PRATOS:"+ "\n"+ PratoFeito.totPrato2);
                }
                resBebi.setText("BEBIDAS :" + "\n" + bebidas);
                resTotal.setText(total);


            }
        }

    }

    public void ChamarFinal(View view) {

        Intent toSelf = new Intent(this, Final.class);
        startActivity(toSelf);


    }
    public void Cancelar(View view) {

        Intent toSelf = new Intent(this, MainActivity.class);
        startActivity(toSelf);




    }









    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
