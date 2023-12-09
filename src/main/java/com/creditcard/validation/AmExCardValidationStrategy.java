package com.creditcard.validation;

public class AmExCardValidationStrategy implements CardValidationStrategy {
    @Override
    public boolean isValid(String cardNumber) {
        return cardNumber.startsWith("3") && cardNumber.length() == 15 &&
               (cardNumber.substring(1, 2).equals("4") || cardNumber.substring(1, 2).equals("7"));
    }
}
