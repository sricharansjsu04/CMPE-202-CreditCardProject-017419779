package com.creditcard.fileio;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import com.creditcard.util.CreditCardWrapper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVFileWriter implements IFileWriter {

    @Override
    public void writeCreditCards(String filePath, List<CreditCardWrapper> creditCards) {
        // Define the CSV format with the appropriate header
        CSVFormat format = CSVFormat.Builder.create(CSVFormat.DEFAULT)
            .setHeader("CardNumber", "CardType", "Error")
            .setSkipHeaderRecord(false) // Set to false to include the header
            .build();

        // Try-with-resources will auto-close the writer and printer
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
             CSVPrinter csvPrinter = new CSVPrinter(writer, format)) {
            for (CreditCardWrapper wrapper : creditCards) {
                if (wrapper.isValid()) {
                    // Valid card: Write card number and card type
                    csvPrinter.printRecord(wrapper.getCreditCard().getCardNumber(), wrapper.getCreditCard().getCardType(), "");
                } else {
                    // Invalid card: Write card number and error message
                    csvPrinter.printRecord(wrapper.getCardNumber(), "", wrapper.getErrorMessage());
                }
            }
            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
