package com.creditcard;

import java.util.List;

import com.creditcard.factory.CSVOperationFactory;
import com.creditcard.factory.FileOperationFactory;
import com.creditcard.factory.JSONOperationFactory;
import com.creditcard.factory.XMLOperationFactory;
import com.creditcard.fileio.IFileParser;
import com.creditcard.fileio.IFileWriter;
import com.creditcard.util.CreditCardWrapper;

public class CreditCardProcessor {
    public static void processFile(String inputFilePath, String outputFilePath) throws Exception {
        FileOperationFactory factory = getFileOperationFactory(inputFilePath);
        IFileParser parser = factory.createFileParser();
        IFileWriter writer = factory.createFileWriter();

        List<CreditCardWrapper> creditCards = parser.parseCreditCards(inputFilePath);
        writer.writeCreditCards(outputFilePath, creditCards);
    }

    private static FileOperationFactory getFileOperationFactory(String filePath) {
        if (filePath.endsWith(".csv")) {
            return new CSVOperationFactory();
        } else if (filePath.endsWith(".json")) {
            return new JSONOperationFactory();
        } else if (filePath.endsWith(".xml")) {
            return new XMLOperationFactory();
        } else {
            throw new IllegalArgumentException("Unsupported file format");
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            throw new IllegalArgumentException("Please provide input and output file paths");
        }
        processFile(args[0], args[1]);
    }
}