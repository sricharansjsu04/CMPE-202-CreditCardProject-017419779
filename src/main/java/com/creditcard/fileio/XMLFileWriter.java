package com.creditcard.fileio;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.creditcard.util.CreditCardWrapper;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class XMLFileWriter implements IFileWriter {

    @Override
    public void writeCreditCards(String filePath, List<CreditCardWrapper> creditCards) {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            // Root element
            Element root = document.createElement("creditCards");
            document.appendChild(root);

            // Adding credit card elements
            for (CreditCardWrapper creditCard : creditCards) {
                Element cardElement = document.createElement("creditCard");
                root.appendChild(cardElement);

                // Card Number
                Element number = document.createElement("cardNumber");
                number.appendChild(document.createTextNode(creditCard.getCardNumber()));
                cardElement.appendChild(number);

                // Card Type or Error
                Element type = document.createElement("cardType");
                String cardTypeOrError = creditCard.isValid() ? creditCard.getCreditCard().getCardType() : creditCard.getErrorMessage();
                type.appendChild(document.createTextNode(cardTypeOrError));
                cardElement.appendChild(type);
            }

            // Create the XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(filePath));

            // Write data to the file
            transformer.transform(domSource, streamResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
