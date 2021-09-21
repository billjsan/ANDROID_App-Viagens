package com.example.appviagens.adapter;

public class CreditCard {

    /**
     * Definição dos campos
     */
    private String mCardNumber;
    private String mCardYear;
    private String mCardMonth;
    private String mName;
    private String mCVV;

    public CreditCard(String cardNumber,String name, String cardMonth, String cardYear, String cardCVV ){

        this.mCardMonth = cardMonth;
        this.mCardNumber = cardNumber;
        this.mCardYear = cardYear;
        this.mName = name;
        this.mCVV = cardCVV;

    }

    public String getMonth(){return this.mCardMonth;}

    public String getYear(){return this.mCardYear;}

    public String getCVV(){return this.mCVV;}

    public String getName(){return this.mName;}

    public String getNumber(){return this.mCardNumber;}

}
