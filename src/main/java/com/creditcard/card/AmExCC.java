package com.creditcard.card;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AmExCC extends CreditCard {

     // No-argument constructor for JAXB
     protected AmExCC() {
        super();
    }


    public AmExCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }

    @Override
    @JsonProperty("cardType")
    public String getCardType() {
        return "AmEx";
    }
    
}
