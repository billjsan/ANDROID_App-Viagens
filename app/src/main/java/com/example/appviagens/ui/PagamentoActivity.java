package com.example.appviagens.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.appviagens.R;

public class PagamentoActivity extends AppCompatActivity {

    private final String PAGAMENTO_TITULO = "PAGAMENTO";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(PAGAMENTO_TITULO);




    }
}