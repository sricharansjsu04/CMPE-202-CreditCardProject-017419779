package com.creditcard.factory;

import com.creditcard.fileio.CSVFileParser;
import com.creditcard.fileio.CSVFileWriter;
import com.creditcard.fileio.IFileParser;
import com.creditcard.fileio.IFileWriter;

public class CSVOperationFactory extends FileOperationFactory {
    @Override
    public IFileParser createFileParser() {
        return new CSVFileParser();
    }

    @Override
    public IFileWriter createFileWriter() {
        return new CSVFileWriter(); // You'll need to implement CSVFileWriter
    }
}