package com.creditcard.fileio;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.creditcard.CreditCardFactory;
import com.creditcard.card.CreditCard;
import com.creditcard.util.CreditCardWrapper;

import java.util.ArrayList;
import java.util.List;

public class XMLFileParser implements IFileParser {

    @Override
    public List<CreditCardWrapper> parseCreditCards(String filePath) {
        List<CreditCardWrapper> creditCards = new ArrayList<>();

        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("creditCard");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String cardNumber = element.getElementsByTagName("cardNumber").item(0).getTextContent();
                String expirationDate = element.getElementsByTagName("expirationDate").item(0).getTextContent();
                String cardHolderName = element.getElementsByTagName("cardHolderName").item(0).getTextContent();

                try {
                    CreditCard creditCard = CreditCardFactory.createCreditCard(cardNumber, expirationDate, cardHolderName);
                    creditCards.add(new CreditCardWrapper(creditCard)); // Valid card
                } catch (IllegalArgumentException e) {
                    creditCards.add(new CreditCardWrapper(cardNumber, e.getMessage())); // Invalid card
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return creditCards;
    }
}
