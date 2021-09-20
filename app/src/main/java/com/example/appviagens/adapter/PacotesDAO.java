package com.example.appviagens.adapter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class PacotesDAO implements Serializable {

    /**
     * metodo que retorna varios pacotes
     * @return
     */
    public List<Pacotes> getPacotes(){

        /**
         * cria uma lista que irá receber um raay de pacotes
         */
        List<Pacotes> pacotes = new ArrayList<>(Arrays.asList(
                new Pacotes("Recife", "recife", 5, new BigDecimal(400.99)),
                new Pacotes("Natal",  "natal", 1, new BigDecimal(300.99)),
                new Pacotes("Vitória", "vitoria", 8, new BigDecimal(900.99)),
                new Pacotes("Fortaleza", "fortaleza", 4, new BigDecimal(500.99)),
                new Pacotes("São Luiz", "sao_luiz", 7, new BigDecimal(1000.99)),
                new Pacotes("Belo Horizonte", "belo_horizonte", 4, new BigDecimal(2000.99)),
                new Pacotes("São Paulo", "sao_paulo", 9, new BigDecimal(5000.99))
        ));

        /**
         * retorna um array com varios pacotes
         */
        return pacotes;
    }
}
