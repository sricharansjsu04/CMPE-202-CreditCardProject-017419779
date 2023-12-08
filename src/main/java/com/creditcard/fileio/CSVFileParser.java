package com.creditcard.fileio;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.creditcard.CreditCardFactory;
import com.creditcard.card.CreditCard;
import com.creditcard.util.CreditCardWrapper;

import java.io.Reader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVFileParser implements IFileParser {

    @Override
    public List<CreditCardWrapper> parseCreditCards(String filePath) throws Exception {
        List<CreditCardWrapper> creditCards = new ArrayList<>();
        Reader in = new FileReader(filePath);
        CSVFormat format = CSVFormat.Builder.create(CSVFormat.DEFAULT)
         .setHeader("CardNumber", "ExpirationDate", "Name")
         .setSkipHeaderRecord(true)
         .build();
        CSVParser parser = new CSVParser(in, format);

        for (CSVRecord record : parser) {
            String cardNumber = record.get("CardNumber");
            try {
                String expirationDate = record.get("ExpirationDate");
                String cardHolderName = record.get("Name");
                CreditCard creditCard = CreditCardFactory.createCreditCard(cardNumber, expirationDate, cardHolderName);
                creditCards.add(new CreditCardWrapper(creditCard));
            } catch (IllegalArgumentException e) {
                // Instead of adding null, add a wrapper with an error message
                creditCards.add(new CreditCardWrapper(cardNumber, e.getMessage()));
            }
        }
        parser.close();
        in.close();
        return creditCards;
    }
}