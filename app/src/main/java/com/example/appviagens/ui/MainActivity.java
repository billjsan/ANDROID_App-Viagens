package com.example.appviagens.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.appviagens.R;
import com.example.appviagens.adapter.MeuAdapter;
import com.example.appviagens.adapter.PacotesDAO;
import com.example.appviagens.util.Const;
public class MainActivity extends AppCompatActivity {

    /**
     * declaro as variaveis
     */
    ListView myList;

    /**
     * instancio um objeto que irá me fornecer os pacotes
     * que eu preciso
     */
    PacotesDAO meusPacotes = new PacotesDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Fonfigura o titulo da activity
         */
        setTitle(getString(R.string.principal_titulo));

         /** configura a lista
         */
        configuraLista();

        /**
         * configura o evento de clique nos elementos
         * da view
         */
        OnClickItem();
    }

    /**
     * Método que configura a lista e a view
     */
    private void configuraLista() {

        Log.d("will", "configuraLista: ");
        /**
         * referencio os meus elementos da view
         */
        myList = findViewById(R.id.lv_listview);

        /**
         * fenifo o adapter e o chama passando a lista que será mostrada e o contexto
         */
        myList.setAdapter(new MeuAdapter(meusPacotes.getPacotes(),this ));
    }

    /**
     * evento de clique em algum item da view
     */
    private void OnClickItem() {
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /**
                 * configura um intent para mudar de actiity passando parametros
                 */
                Intent i = new Intent(MainActivity.this, ResumoPacoteActivity.class);
                i.putExtra(Const.KEY_COD_POSICAO, position);
                startActivity(i);
            }
        });
    }
}