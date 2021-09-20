package com.example.appviagens.util;

public class FormataDiasUtil {

    static public String formataDias(int dias) {
        /**
         * realiza o tratamento do numero de dias para fazer concordância
         * do texto exibido
         */
        String diasF = "";
        if (dias == 1){
            diasF = dias + Const.KEY_COD_DIA_SINGULAR;
        }
        if(dias > 1){
            diasF = dias + Const.KEY_COD_DIA_PLURAL;
        }
        return diasF;
    }

}
