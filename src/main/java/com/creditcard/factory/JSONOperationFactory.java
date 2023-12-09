package com.creditcard.factory;

import com.creditcard.fileio.IFileParser;
import com.creditcard.fileio.IFileWriter;
import com.creditcard.fileio.JSONFileParser;
import com.creditcard.fileio.JSONFileWriter;

public class JSONOperationFactory extends FileOperationFactory {

    @Override
    public IFileParser createFileParser() {
        return new JSONFileParser();
    }

    @Override
    public IFileWriter createFileWriter() {
        return new JSONFileWriter(); 
    }
     
}
