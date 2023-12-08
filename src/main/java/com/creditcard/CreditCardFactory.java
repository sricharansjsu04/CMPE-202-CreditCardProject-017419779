package com.creditcard;

import com.creditcard.card.AmExCC;
import com.creditcard.card.CreditCard;
import com.creditcard.card.DiscoverCC;
import com.creditcard.card.MasterCC;
import com.creditcard.card.VisaCC;

public class CreditCardFactory  {

    public static CreditCard createCreditCard(String cardNumber, String expirationDate, String cardHolderName) {


        System.out.println("Card number and length is "+ cardNumber+ " length is "+cardNumber.length());
        
        if (cardNumber.startsWith("4") && (cardNumber.length() == 13 || cardNumber.length() == 16)) {
            return new VisaCC(cardNumber, expirationDate, cardHolderName);
        } else if (cardNumber.startsWith("5") && cardNumber.length() == 16 && 
                   Integer.parseInt(cardNumber.substring(1, 2)) >= 1 && 
                   Integer.parseInt(cardNumber.substring(1, 2)) <= 5) {
            return new MasterCC(cardNumber, expirationDate, cardHolderName);
        } else if (cardNumber.startsWith("3") && cardNumber.length() == 15 &&
                   (cardNumber.substring(1, 2).equals("4") || cardNumber.substring(1, 2).equals("7"))) {
            return new AmExCC(cardNumber, expirationDate, cardHolderName);
        } else if (cardNumber.startsWith("6011") && cardNumber.length() == 16) {
            return new DiscoverCC(cardNumber, expirationDate, cardHolderName);
        } else {
            throw new IllegalArgumentException("Invalid credit card number");
        }
    }
}
