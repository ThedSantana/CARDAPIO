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

import java.text.NumberFormat;
import java.util.ArrayList;


public class SelfService extends ActionBarActivity {
    public static final  int RESULTADO = 1;
    ArrayList<Double> preco = new ArrayList<Double>();
    ArrayList<String> opcao = new ArrayList<String>();
    public static double b =0.00;
    public static String opcoes2="";
    TextView opcoes;
    TextView precos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self_service);

        opcoes = (TextView) findViewById(R.id.tot_opcao);
        precos = (TextView) findViewById(R.id.txt_total);
        opcoes.setEnabled(false);
        precos.setEnabled(false);
        opcao.clear();
        preco.clear();
    }

       public void SelecionarOpcao(View view){
           boolean checked = ((CheckBox)view).isChecked();

           switch(view.getId()){
               case R.id.chk_arroz:
                   if (checked){
                       preco.add(5.00);
                       opcao.add("Arroz Branco");
                   }else{
                       preco.remove(5.00);
                       opcao.remove("Arroz Branco");
                   }
                   break;
               case R.id.chk_feijao:
                   if (checked){
                       preco.add(6.00);
                       opcao.add("Feijão Carioca");
                   }else{
                       preco.remove(6.00);
                       opcao.remove("Feijão Carioca");
                   }
                   break;
               case R.id.chk_legume:
                   if (checked){
                       preco.add(4.00);
                       opcao.add("Legumes Diversos");
                   }else{
                       preco.remove(4.00);
                       opcao.remove("Legumes Diversos");
                   }
                   break;
               case R.id.chk_salada:
                   if (checked){
                       preco.add(3.00);
                       opcao.add("Salada de Tomate");
                   }else{
                       preco.remove(3.00);
                       opcao.remove("Salada de Tomate");
                   }
                   break;
               case R.id.chk_file:
                   if (checked){
                       preco.add(8.00);
                       opcao.add("Filé de Frango");
                   }else{
                       preco.remove(8.00);
                       opcao.remove("Filé de Frango");
                   }
                   break;
               case R.id.chk_bife:
                   if (checked){
                       preco.add(9.90);
                       opcao.add("Bife Acebolado");
                   }else{
                       preco.remove(9.90);
                       opcao.remove("Bife Acebolado");
                   }
                   break;
               case R.id.chk_salmao:
                   if (checked){
                       preco.add(13.00);
                       opcao.add("Salmão Assado");
                   }else{
                       preco.remove(13.00);
                       opcao.remove("Salmão Assado");
                   }
                   break;


           }
           listarOpcao(view);
       }
    public void listarOpcao(View view){
        NumberFormat z = NumberFormat.getCurrencyInstance();
        String totPrato = "";
        Double totPreco = 0.0;


            for (Integer i = 0; i < opcao.size(); i++) {
                totPreco += preco.get(i);
                totPrato += opcao.get(i) + "\n";
            }


                b = totPreco;
                opcoes2 = totPrato;
            opcoes.setText(totPrato);
            opcoes.setEnabled(true);
            precos.setText("TOTAL R" + z.format(totPreco));
            precos.setEnabled(true);


    }

    public void enviarDados(View view){

        if(opcao.isEmpty() || preco.isEmpty()){
            String msg = "Selecione Uma Opção";
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }else {
            Bundle params = new Bundle();
            params.putString("prato", opcoes.getText().toString());
            params.putString("total", precos.getText().toString());

            Intent intent = new Intent(this, Bebida.class);
            intent.putExtras(params);

            startActivityForResult(intent, RESULTADO);
        }


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
