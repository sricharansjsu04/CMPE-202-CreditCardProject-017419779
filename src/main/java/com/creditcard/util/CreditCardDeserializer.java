package com.creditcard.util;

import com.creditcard.CreditCardFactory;
import com.creditcard.card.CreditCard;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class CreditCardDeserializer extends JsonDeserializer<CreditCardWrapper> {

    @Override
    public CreditCardWrapper deserialize(JsonParser jsonParser, DeserializationContext ctxt) 
            throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String cardNumber = node.get("cardNumber").asText();
        String expirationDate = node.has("expirationDate") ? node.get("expirationDate").asText() : null;
        String cardHolderName = node.has("cardHolderName") ? node.get("cardHolderName").asText() : null;

        try {
            CreditCard creditCard = CreditCardFactory.createCreditCard(cardNumber, expirationDate, cardHolderName);
            return new CreditCardWrapper(creditCard); // Valid card
        } catch (IllegalArgumentException e) {
            return new CreditCardWrapper(cardNumber, e.getMessage()); // Invalid card
        }
    }
}
