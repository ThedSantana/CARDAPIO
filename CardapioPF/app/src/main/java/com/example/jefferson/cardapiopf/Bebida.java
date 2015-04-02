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

import java.text.NumberFormat;
import java.util.ArrayList;


public class Bebida extends ActionBarActivity {
    public static final  int RESULTADO = 3;
    ArrayList<String> bebidas = new ArrayList<String>();
    ArrayList<Double> precoBebidas = new ArrayList<Double>();
    TextView listaBebida;
    TextView resTotal;
    double c;
    String total;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bebida);
        c = 0.00;

        listaBebida = (TextView) findViewById(R.id.txt_list_bebida);
        listaBebida.setEnabled(false);
        resTotal = (TextView) findViewById(R.id.txt_beb_total);
        resTotal.setEnabled(false);
        Intent intent = getIntent();
        if (intent != null) {
            Bundle params = intent.getExtras();
            if (params != null) {
                 total = params.getString("total");


                  resTotal.setText(total);
                 resTotal = (TextView) findViewById(R.id.txt_beb_total);
                resTotal.setEnabled(true);



            }

    }

    }

    public void SelecionarBebida(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.chk_coca:
                if (checked) {
                    precoBebidas.add(3.50);
                    bebidas.add("Coca Cola");
                } else {
                    precoBebidas.remove(3.50);
                    bebidas.remove("Coca Cola");
                }
                break;
            case R.id.chk_fanta:
                if (checked) {
                    precoBebidas.add(3.50);
                    bebidas.add("Fanta");
                } else {
                    precoBebidas.remove(3.50);
                    bebidas.remove("Fanta");
                }
                break;
            case R.id.chk_skol:
                if (checked) {
                    precoBebidas.add(4.00);
                    bebidas.add("Skol");
                } else {
                    precoBebidas.remove(4.00);
                    bebidas.remove("Skol");
                }
                break;
            case R.id.chk_brahma:
                if (checked) {
                    precoBebidas.add(4.00);
                    bebidas.add("Brahma");
                } else {
                    precoBebidas.remove(4.00);
                    bebidas.remove("Brahma");
                }
                break;
            case R.id.chk_vinho:
                if (checked) {

                    precoBebidas.add(30.00);
                    bebidas.add("Cantina da Serra");
                } else {
                    precoBebidas.remove(30.00);
                    bebidas.remove("Cantina da Serra");
                }
                break;
            case R.id.chk_agua:
                if (checked) {

                    precoBebidas.add(3.00);
                    bebidas.add("Bona Font");
                } else {
                    precoBebidas.remove(3.00);
                    bebidas.remove("Bona Font");
                }
                break;

        }
        listar(view);
    }

    public void listar(View view) {
        NumberFormat z = NumberFormat.getCurrencyInstance();
        String totBebida = "";
        Double totPreco = 0.00;
        for (Integer i = 0; i < bebidas.size();i++) {
            totBebida += bebidas.get(i) + "\n";
            totPreco += precoBebidas.get(i);
        }


         if(PratoFeito.a != 0.00) {
             c = totPreco + PratoFeito.a;
         }else{
             c = totPreco + SelfService.b  ;
         }

        listaBebida.setText(totBebida);
        listaBebida.setEnabled(true);
        resTotal.setText("TOTAL R" + z.format(c));
        resTotal.setEnabled(true);



        }
    public void EnviarDadosBebidas(View view){


            Bundle params = new Bundle();
            params.putString("c", resTotal.getText().toString());
            params.putString("beb", listaBebida.getText().toString());



            Intent intent = new Intent(this, Resumo.class);
            intent.putExtras(params);

            startActivityForResult(intent, RESULTADO);



    }

}
