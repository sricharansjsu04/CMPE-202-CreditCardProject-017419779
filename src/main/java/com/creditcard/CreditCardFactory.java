package com.creditcard;

import com.creditcard.card.*;
import com.creditcard.validation.*;

public class CreditCardFactory {

    public static CreditCard createCreditCard(String cardNumber, String expirationDate, String cardHolderName) {
        // Common validations (null, empty, non-numeric, length)
        commonValidations(cardNumber);

        // Strategy pattern usage
        if (new VisaCardValidationStrategy().isValid(cardNumber)) {
            return new VisaCC(cardNumber, expirationDate, cardHolderName);
        } else if (new MasterCardValidationStrategy().isValid(cardNumber)) {
            return new MasterCC(cardNumber, expirationDate, cardHolderName);
        } else if (new AmExCardValidationStrategy().isValid(cardNumber)) {
            return new AmExCC(cardNumber, expirationDate, cardHolderName);
        } else if (new DiscoverCardValidationStrategy().isValid(cardNumber)) {
            return new DiscoverCC(cardNumber, expirationDate, cardHolderName);
        } else {
            throw new IllegalArgumentException("Invalid: not a possible card number");
        }
    }

    private static void commonValidations(String cardNumber) {
        if (cardNumber == null || cardNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid: empty/null card number");
        }
        if (!cardNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid: non numeric characters");
        }
        if (cardNumber.length() > 19) {
            throw new IllegalArgumentException("Invalid credit card: Credit card numbers cannot exceed 19 digits");
        }
    }
}
