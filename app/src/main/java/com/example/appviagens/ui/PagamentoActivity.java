package com.example.appviagens.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appviagens.R;
import com.example.appviagens.adapter.CreditCard;
import com.example.appviagens.adapter.Pacotes;
import com.example.appviagens.adapter.PacotesDAO;
import com.example.appviagens.util.Const;
import com.example.appviagens.util.FormataPrecoUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PagamentoActivity extends AppCompatActivity {

    /**
     * Declara as veriaveis da view
     */
    private EditText et_nome, et_ano, et_mes, et_cod, et_num;
    private Button bt_finalizar;
    private TextView tv_preco;

    /**
     * metodo chamado quando a activity é criada
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        /**
         * define o título da activity
         */
        setTitle(getString(R.string.pagamento_titulo));

        /**
         * referencia os elementos da view
         */
        refEleView();

        /**
         * mostra o conteúdo dos campos
         */
        showContent();

        /**
         * Define ação ao clicar
         */
        bt_finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(PagamentoActivity.this, "Concluído",
                        Toast.LENGTH_SHORT).show();

                /**
                 * Aqui acaba o escopo da feature
                 * os dados sao copiados mas nao há
                 * o que fazer com eles ainda.
                 */
                CreditCard cred = makeCard();

                /**
                 * Limpa os campos digitados pelo usuario
                 */
                clearFields();
            }
        });
    }

    /**
     * Limpa os capos digitados pelo usuario
     */
    public void clearFields(){

        et_nome.setText("");
        et_ano.setText("");
        et_mes.setText("");
        et_cod.setText("");
        et_num.setText("");
    }

    /**
     * Captura as informações digitadas
     * a ordem desses parâmetros conicidem
     * com a ordem dos parametros do contrutor
     * da classe cartao
     *
     * retorna um array com os itens
     */
    private ArrayList<String> captureInfo(){

        ArrayList<String> card = new ArrayList<>();

        card.add(et_num.getText().toString());
        card.add(et_nome.getText().toString());
        card.add(et_mes.getText().toString());
        card.add(et_ano.getText().toString());
        card.add(et_cod.getText().toString());

        return card;
    }

    /**
     * Recebe um ArrayList com os itens
     * digitanos pelo usuario na ordem que
     * serao usados no contrutor, depende do metodo
     * captureInfo()
     * @return um objeto cartão
     */
    private CreditCard makeCard(){

        ArrayList<String> card = captureInfo();

        CreditCard cartao = new CreditCard(card.get(0), card.get(1), card.get(2),
                card.get(3), card.get(4));

        return cartao ;

    }

    /**
     * Imprime o conteúdo do pacote na view
     */
    private void showContent(){

        tv_preco.setText(getPricePackage());

    }

    /**
     * Recupera uma Sring com o preço do
     * pacote selecionado
     * @return
     */
    private String getPricePackage(){

        Pacotes meuPacote = getPackageSelected();

        String preco = FormataPrecoUtil.formataPeco(meuPacote.getPreco());

        return preco;
    }

    /**
     * Retorna o pacote que foi clicado
     * @return
     */
    private Pacotes getPackageSelected(){

        PacotesDAO pacotesDAO = new PacotesDAO();

        return pacotesDAO.getPacotes().get(getIntentReceiverPosition());
    }

    /**
     * Retorna a posição atual do item
     * no array de pacotes, indicando
     * qual item foi clicado
     * @return
     */
    private int getIntentReceiverPosition(){

        Intent i = getIntent();

        return i.getExtras().getInt(Const.KEY_COD_POSICAO);
    }

    /**
     * Referencia as variáveis com os objetos da view
     */
    private void refEleView() {

        et_nome = findViewById(R.id.et_pagamento_cartao_nome);
        et_ano = findViewById(R.id.et_pagamento_cartao_ano);
        et_cod = findViewById(R.id.et_pagamento_cartao_cvc);
        et_ano = findViewById(R.id.et_pagamento_cartao_ano);
        et_mes = findViewById(R.id.et_pagamento_cartao_mes);
        et_num = findViewById(R.id.et_pagamento_cartao_numero);

        tv_preco = findViewById(R.id.tv_pagamento_preco);

        bt_finalizar = findViewById(R.id.bt_pagamento_finalizar_compra);

    }
}