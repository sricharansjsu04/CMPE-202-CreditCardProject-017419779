package com.creditcard.card;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DiscoverCC extends CreditCard{

    public DiscoverCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }

    @Override
    public String getCardType() {
        return "DiscoverCC";
    }
     
}
