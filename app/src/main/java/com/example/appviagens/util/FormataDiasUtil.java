package com.example.appviagens.util;


import android.content.Context;
import android.view.View;

import com.example.appviagens.R;

public class FormataDiasUtil {

    static public String formataDias(int dias) {


        /**
         * realiza o tratamento do numero de dias para fazer concordância
         * do texto exibido
         */
        String diasF = "";

        //String eu = getString(R.string.resumoPacote_titulo);

        if (dias == 1){
            diasF = dias + Const.KEY_COD_DIA_SINGULAR;
        }
        if(dias > 1){
            diasF = dias + Const.KEY_COD_DIA_PLURAL;
        }
        return diasF;
    }

    /**
     * cria uma sobrecarga
     * para a solucao com o context
     * @param dias
     * @param contexto
     * @return
     */
    static public String formataDias(int dias, Context contexto){
        String txt = "";
        if(dias == 1){

            txt = String.format("%s %s",dias,contexto.getResources().getString(R.string.principal_dia_singular));
        }else if (dias > 1){

            txt = String.format("%s %s",dias,contexto.getResources().getString(R.string.principal_dia_plural));
        }
        return txt;
    }

}