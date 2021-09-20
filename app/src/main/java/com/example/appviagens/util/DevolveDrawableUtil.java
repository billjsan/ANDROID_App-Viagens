package com.example.appviagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.example.appviagens.adapter.Pacotes;

public class DevolveDrawableUtil {

    public static  Drawable devolveDrawable(String drawableTexto, Context context) {
        /**
         * pede os recursos do contexto
         */
        Resources resources = context.getResources();

        /**
         * recupera qual o nome da imagem que será exibida de a cordo com o item da view
         */
        int idDrawable = resources.getIdentifier(drawableTexto, Const.KEY_COD_DRAWABLE, context.getPackageName());

        /**
         * cria um drawable para mostrar as imagens
         */
        Drawable drawImagePacote = resources.getDrawable(idDrawable);
        return drawImagePacote;
    }
}
