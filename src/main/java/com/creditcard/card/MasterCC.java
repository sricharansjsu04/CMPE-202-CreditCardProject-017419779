package com.creditcard.card;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MasterCC extends CreditCard{

    // No-argument constructor for JAXB
    protected MasterCC() {
        super();
    }

    public MasterCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }


    @Override
    public String getCardType() {
        return "Master";
    }
    
}
