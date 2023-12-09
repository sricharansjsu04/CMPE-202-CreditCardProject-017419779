package com.creditcard.card;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VisaCC extends CreditCard {

    // No-argument constructor for JAXB
    protected VisaCC() {
        super();
    }

    public VisaCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }

    @Override
    public String getCardType() {
        return "Visa";
    }
}
