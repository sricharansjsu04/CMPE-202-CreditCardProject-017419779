package com.creditcard.card;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class CreditCard {
    protected String cardNumber;
    protected String expirationDate;
    protected String cardHolderName;

    // Protected no-argument constructor for JAXB
    protected CreditCard() {
    }

    public CreditCard(String cardNumber, String expirationDate, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cardHolderName = cardHolderName;
    }

    public abstract String getCardType();

    @JsonProperty("cardNumber")
    public String getCardNumber(){
        return this.cardNumber;
    }

    @JsonIgnore
    public String getExpirationDate(){
        return this.expirationDate;
    }

    @JsonIgnore
    public String getCardHolderName(){
        return this.cardHolderName;
    }
}

