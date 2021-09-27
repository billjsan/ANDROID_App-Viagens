package com.example.appviagens.util;


import android.content.Context;

import androidx.annotation.NonNull;

import com.example.appviagens.R;


import androidx.annotation.NonNull;


import java.util.Calendar;

public class FormataDataUtil {


    public static final String SEPARADOR_DATA = "/";
    public static final String PREFIXO_ANO = " de ";
    public static final String PREFIXO_DATA_VOLTA = " até ";

    /**
     * Recebe o número de dias do pacote e retorna uma
     * String formatada com a data de ida e de volta com
     * base na data atual
     * @param dias
     * @return
     */
    public static String getDateFormatedBasedOnDays(int dias){

        Calendar mDataIda = Calendar.getInstance();

        Calendar mDataVolta = Calendar.getInstance();

        mDataVolta.add(Calendar.DAY_OF_MONTH,dias);

        return mDataIda.get(Calendar.DAY_OF_MONTH) + SEPARADOR_DATA + formatMonthToNumber(mDataIda) +
                PREFIXO_DATA_VOLTA + mDataVolta.get(Calendar.DAY_OF_MONTH) + SEPARADOR_DATA +
                formatMonthToNumber(mDataVolta) + PREFIXO_ANO + mDataVolta.get(Calendar.YEAR);
    }

    /**
     * recebe um numero de dias e um contexto
     * e retorna uma string formata com a data de ida
     * e de volta com base na data atual e do style
     * @param dias
     * @param context
     * @return
     */
    public static String getDateFormatedBasedOnDays(int dias, Context context){

        Calendar mDataIda = Calendar.getInstance();

        Calendar mDataVolta = Calendar.getInstance();

        mDataVolta.add(Calendar.DAY_OF_MONTH,dias);

        String date = String.format("%s%s%s %s %s%s%s %s %s",
                mDataIda.get(Calendar.DAY_OF_MONTH),
                context.getResources().getString(R.string.resumo_pacote_data_separador),
                formatMonthToNumber(mDataIda),
                context.getResources().getString(R.string.resumo_pacote_data_prefix_volta),
                mDataVolta.get(Calendar.DAY_OF_MONTH),
                context.getResources().getString(R.string.resumo_pacote_data_separador),
                formatMonthToNumber(mDataVolta),
                context.getResources().getString(R.string.resumo_pacote_data_prefix_ano),
                mDataVolta.get(Calendar.YEAR));

        return  date;
    }

    /**
     * corrige o valor numero referente ao mes atual
     * @param calendario
     * @return String com o numero do mes atual
     */
    @NonNull
    private static String formatMonthToNumber(Calendar calendario) {
        int mes = calendario.get(Calendar.MONTH);
        mes+=1;
        String mesF = String.valueOf(mes);
        return mesF;
    }
}
