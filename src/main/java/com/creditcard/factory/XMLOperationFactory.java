package com.creditcard;

import com.creditcard.fileio.FileOperationFactory;
import com.creditcard.fileio.IFileParser;
import com.creditcard.fileio.IFileWriter;
import com.creditcard.fileio.XMLFileParser;
import com.creditcard.fileio.XMLFileWriter;

public class XMLOperationFactory extends FileOperationFactory {

    @Override
    public IFileParser createFileParser() {
        return new XMLFileParser();
    }

    @Override
    public IFileWriter createFileWriter() {
        return new XMLFileWriter(); 
    }
    
}
