package com.example.appviagens.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appviagens.R;
import com.example.appviagens.adapter.Pacotes;
import com.example.appviagens.adapter.PacotesDAO;
import com.example.appviagens.util.Const;
import com.example.appviagens.util.DevolveDrawableUtil;
import com.example.appviagens.util.FormataDataUtil;
import com.example.appviagens.util.FormataDiasUtil;
import com.example.appviagens.util.FormataPrecoUtil;

public class ResumoPacoteActivity extends AppCompatActivity {


    /**
     * Declaração das variaveis
     * @param savedInstanceState
     */
    TextView tv_local;
    TextView tv_dias;
    TextView tv_preco;
    TextView tv_data;

    ImageView imagem;

    Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resumo_pacote);


        /**
         * Define o titulo da activity
         */
        setTitle(getString(R.string.resumo_pacote_titulo));

        /**
         * referencia os elementos da view
         */
        getReferencesViews();

        /**
         * define o conteudo da view
         */
        setContentViews();

        /**
         * crio o evento do clique
         */
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
                i.putExtra(Const.KEY_COD_POSICAO,getPositionItemReceived());
                finish();
                startActivity(i);
            }
        });

    }

    /**
     * Imprime o conteudo
     */
    private void setContentViews() {

        tv_local.setText(getInfoPackage().getLocal());

        tv_dias.setText(FormataDiasUtil.formataDias(getInfoPackage().getDias(), this));
        tv_preco.setText(FormataPrecoUtil.formataPeco(getInfoPackage().getPreco()));
        tv_data.setText(FormataDataUtil.getDateFormatedBasedOnDays(getInfoPackage().getDias(), this));
        imagem.setImageDrawable(DevolveDrawableUtil.devolveDrawable(getInfoPackage().getImagem(), this));

    }

    /**
     * Referencia os elementos da view
     */
    private void getReferencesViews() {

        tv_local = findViewById(R.id.tv_resumo_local);
        tv_dias = findViewById(R.id.tv_resumo_dias);
        tv_preco = findViewById(R.id.tv_resumo_preco);
        tv_data = findViewById(R.id.tv_resumo_data);

        imagem = findViewById(R.id.iv_resumo_imagem);

        botao = findViewById(R.id.bt_resumo_pagar);
    }


    private int getPositionItemReceived(){

        Intent i = getIntent();

        return i.getExtras().getInt(Const.KEY_COD_POSICAO);
    }

    /**
     * recupera informaçoes da view que foi clicada
     * @return
     */
    private Pacotes getInfoPackage() {

        Intent i = getIntent();
        PacotesDAO meuspkts = new PacotesDAO();

        /**
         * retorna informaçoes do pacote que foi clicado
         */
        return meuspkts.getPacotes().get(i.getExtras().getInt(Const.KEY_COD_POSICAO));
    }
}