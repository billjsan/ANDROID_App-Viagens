package com.example.appviagens.util;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class FormataPrecoUtil {

    public static String formataPeco(BigDecimal valor) {
        /**
         * formata o valor do pacote a ser exibido ao usuario para
         * valor monetário brasileiro
         */
        String precoF = NumberFormat.getCurrencyInstance().format(valor);

        return precoF;
    }
}
