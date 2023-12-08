package com.creditcard;

import static org.junit.Assert.*;

import org.junit.Test;

import com.creditcard.card.CreditCard;
import com.creditcard.card.VisaCC;

public class CreditCardFactoryTest {

    @Test
    public void testValidVisaCard() {
        CreditCard card = CreditCardFactory.createCreditCard("4532758771091795", "12/23", "John Doe");
        assertTrue(card instanceof VisaCC);
    }

    // Add similar tests for MasterCard, AmEx, and Discover

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCard() {
        CreditCardFactory.createCreditCard("123456789012", "12/23", "John Doe");
    }
}
