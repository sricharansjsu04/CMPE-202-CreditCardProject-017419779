package com.creditcard.card;

import org.junit.Test;
import static org.junit.Assert.*;


public class CreditCardTest {

    @Test
    public void testCardNumber() {
        CreditCard card = new VisaCC("1234567890123456", "12/25", "John Doe");
        assertEquals("1234567890123456", card.getCardNumber());
    }

    @Test
    public void testCardType() {
        CreditCard card = new MasterCC("1234567890123456", "12/25", "John Doe");
        assertEquals("Master", card.getCardType());
    }
}
