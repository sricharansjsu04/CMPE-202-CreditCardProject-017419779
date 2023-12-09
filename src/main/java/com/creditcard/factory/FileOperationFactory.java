package com.creditcard.factory;

import com.creditcard.fileio.IFileParser;
import com.creditcard.fileio.IFileWriter;

public abstract class FileOperationFactory {
    public abstract IFileParser createFileParser();
    public abstract IFileWriter createFileWriter();
}