package com.creditcard.validation;

public class MasterCardValidationStrategy implements CardValidationStrategy {
    @Override
    public boolean isValid(String cardNumber) {
        return cardNumber.startsWith("5") && cardNumber.length() == 16 &&
               Integer.parseInt(cardNumber.substring(1, 2)) >= 1 &&
               Integer.parseInt(cardNumber.substring(1, 2)) <= 5;
    }
}
