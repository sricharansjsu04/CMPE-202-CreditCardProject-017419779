package com.creditcard.util;

import com.creditcard.card.CreditCard;

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
    public boolean isValid() {
        return creditCard != null;
    }

    // Getters
    public CreditCard getCreditCard() {
        return creditCard;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getCardNumber() {
        return isValid() ? creditCard.getCardNumber() : cardNumber;
    }
}
