package com.creditcard.validation;

public class VisaCardValidationStrategy implements CardValidationStrategy {
    @Override
    public boolean isValid(String cardNumber) {
        // Implement Visa card number validation logic
        return cardNumber.startsWith("4") && (cardNumber.length() == 13 || cardNumber.length() == 16);
    }
}

// Similar classes for MasterCC, AmExCC, DiscoverCC
