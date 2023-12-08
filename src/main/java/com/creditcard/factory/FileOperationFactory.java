package com.creditcard.fileio;

public abstract class FileOperationFactory {
    public abstract IFileParser createFileParser();
    public abstract IFileWriter createFileWriter();
}