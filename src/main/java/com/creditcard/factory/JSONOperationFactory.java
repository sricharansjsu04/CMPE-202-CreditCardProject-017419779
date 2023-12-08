package com.creditcard.fileio;

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
