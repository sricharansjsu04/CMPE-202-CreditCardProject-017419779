package com.creditcard.validation;

public interface CardValidationStrategy {
    boolean isValid(String cardNumber);
}
