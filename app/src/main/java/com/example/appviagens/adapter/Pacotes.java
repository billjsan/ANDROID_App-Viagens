package com.example.appviagens.adapter;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class Pacotes {

    /**
     * declaração das variaveis de instancia
     */
    private final String local;
    private final String imagem;
    private final int dias;
    private final BigDecimal preco;



    /**
     * declaração do contrutor
     * @param local
     * @param imagens
     * @param dias
     * @param preco
     */
    public Pacotes(String local, String imagens, int dias, BigDecimal preco ) {
        this.local = local;
        this.imagem = imagens;
        this.dias = dias;
        this.preco = preco;

    }

    /**
     * metodo que retorna o local
     * @return
     */
    public String getLocal(){
        return local;
    }

    /**
     * metodo que retorna a imagem
     * @return
     */
    public String getImagem(){
        return imagem;
    }

    /**
     * metodo que retorna os dias
     * @return
     */
    public int getDias(){
        return dias;
    }

    /**
     * metodo que retorna o preco
     * @return
     */
    public BigDecimal getPreco(){
        return preco;
    }


}
