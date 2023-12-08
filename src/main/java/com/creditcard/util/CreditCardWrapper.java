package com.creditcard.util;

import com.creditcard.card.CreditCard;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreditCardWrapper {
    private CreditCard creditCard;
    private String errorMessage;
    private String cardNumber; // Store the card number for reference

    // Constructor for valid credit card
    public CreditCardWrapper(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    // Constructor for invalid credit card
    public CreditCardWrapper(String cardNumber, String errorMessage) {
        this.cardNumber = cardNumber;
        this.errorMessage = errorMessage;
    }

    // Check if the wrapper contains a valid credit card
    @JsonIgnore
    public boolean isValid() {
        return creditCard != null;
    }

    // Getters
    @JsonIgnore
    public CreditCard getCreditCard() {
        return creditCard;
    }

    @JsonIgnore
    public String getErrorMessage() {
        return errorMessage;
    }


    public String getCardNumber() {
        return isValid() ? creditCard.getCardNumber() : cardNumber;
    }

    @JsonProperty("cardType")
    public String getCardTypeOrError() {
        if (isValid()) {
            return creditCard.getCardType();
        } else {
            return errorMessage;
        }
    }
}
