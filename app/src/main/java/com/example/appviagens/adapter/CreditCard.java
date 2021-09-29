package com.example.appviagens.adapter;

import java.math.BigDecimal;

public class CreditCard {

    /**
     * Definição das variaveis
     * de instancia
     */
    private final String mCardNumber;
    private final String mCardYear;
    private final String mCardMonth;
    private final String mName;
    private final String mCVV;

    /**
     * para motivos de teste
     * variavel estatica para 'reter' o valor
     *atual após a compra
     */
    private static double mBalance = 10000.00;

    public CreditCard(String cardNumber,String name, String cardMonth, String cardYear, String cardCVV ){

        this.mCardMonth = cardMonth;
        this.mCardNumber = cardNumber;
        this.mCardYear = cardYear;
        this.mName = name;
        this.mCVV = cardCVV;
    }

    /**
     * metodos get
     * @return
     */
    public String getMonth(){return this.mCardMonth;}

    public String getYear(){return this.mCardYear;}

    public String getCVV(){return this.mCVV;}

    public String getName(){return this.mName;}

    public String getNumber(){return this.mCardNumber;}

    /**
     * checa se os dados do cartao sao validos
     */
    public boolean isValid() {

        boolean _isValid = false;

        /**
         * vrifica de todos os campos foram
         * preenchidos completamnte
         */
        if (mCardYear.length() == 2) {
            if (mCardNumber.length() == 11) {
                if (mCVV.length() > 2) {
                    if (mCardMonth.length() == 2) {
                        if(!mName.isEmpty())
                        _isValid = true;
                    }
                }
            }
        }

        return _isValid;
    }

    /**
     * Verifica se o cartao possui saldo
     * suficiente para a compra
     * @param sell
     * @return
     */
    public boolean hasBalance(BigDecimal sell){

        BigDecimal balance = new BigDecimal(mBalance);

        /**
         * verifica se pussui saldo e atualiza
         * o saldo
         */
        if(sell.compareTo(balance) <= 0){

            mBalance = mBalance - sell.doubleValue();
            return true;
        }

        return false;
    }

}