package com.creditcard.validation;

public class DiscoverCardValidationStrategy implements CardValidationStrategy {
    @Override
    public boolean isValid(String cardNumber) {
        return cardNumber.startsWith("6011") && cardNumber.length() == 16;
    }
}
