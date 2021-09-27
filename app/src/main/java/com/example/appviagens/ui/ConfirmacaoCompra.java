package com.example.appviagens.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.appviagens.R;

public class ConfirmacaoCompra extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao_compra);

        /**
         * define o titulo da activity
         */
        setTitle(getString(R.string.confirmacaoPagamento_titulo_app));
    }
}