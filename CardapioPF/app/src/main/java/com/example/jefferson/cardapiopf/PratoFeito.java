package com.example.jefferson.cardapiopf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ExecutionException;


public class PratoFeito extends ActionBarActivity {
    public static final  int RESULTADO = 3;
    public static ArrayList<Double> preco = new ArrayList<Double>();
    public static ArrayList<String> prato = new ArrayList<String>();
    public static double a =0.00;
      TextView pratos;
     TextView precos;
    public static String totPrato2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prato_feito);

        pratos = (TextView) findViewById(R.id.tot_prato);
        precos = (TextView) findViewById(R.id.tot_preco);
        pratos.setEnabled(false);
        precos.setEnabled(false);
        prato.clear();
        preco.clear();
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public void Selecionar(View view){
        boolean checked = ((CheckBox)view).isChecked();
        switch(view.getId()){
            case R.id.chk_virado:
                if (checked){
                    preco.add(15.00);
                    prato.add("Virado a Paulista");
                }else{
                    preco.remove(15.00);
                    prato.remove("Virado a Paulista");
                }
                break;
            case R.id.chk_dobradinha:
                if (checked){
                    preco.add(12.00);
                    prato.add("Dobradinha");
                }else{
                    preco.remove(12.00);
                    prato.remove("Dobradinha");
                }
                break;
            case R.id.chk_feijoada:
                if (checked){
                    preco.add(25.00);
                    prato.add("Feijoada");
                }else{
                    preco.remove(25.00);
                    prato.remove("Feijoada");
                }
                break;
            case R.id.chk_macarrao:
                if (checked){
                    preco.add(16.50);
                    prato.add("Macarrão");
                }else{
                    preco.remove(16.50);
                    prato.remove("Macarrão");
                }
                break;
            case R.id.chk_isca:
                if (checked){
                    preco.add(17.80);
                    prato.add("Isca");
                }else{
                    preco.remove(17.80);
                    prato.remove("Isca");
                }
                break;
        }
        listar(view);
    }
    public void listar(View view){
        NumberFormat z = NumberFormat.getCurrencyInstance();

        String totPrato = "";
        double totPreco = 0.00;


        for (Integer i = 0; i < prato.size(); i++) {
                totPreco += preco.get(i);
                totPrato += prato.get(i) + "\n";

            }

            a = totPreco;

            totPrato2 = totPrato;





            pratos.setText(totPrato);
            pratos.setEnabled(true);
            precos.setText("TOTAL R" + z.format(totPreco));
            precos.setEnabled(true);


    }

    public void enviarDados(View view){

        if(prato.isEmpty()|| (prato.isEmpty())){

            String msg = "Selecione Uma Opção";
            Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
        }else {
            Bundle params = new Bundle();

            params.putString("prato", pratos.getText().toString());
            params.putString("total", precos.getText().toString());

            Intent bebida = new Intent(this, Bebida.class);
            bebida.putExtras(params);

            startActivityForResult(bebida, RESULTADO);
        }


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
