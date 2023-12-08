package com.creditcard.fileio;

import java.util.List;

import com.creditcard.util.CreditCardWrapper;

public interface IFileWriter {
    void writeCreditCards(String filePath, List<CreditCardWrapper> creditCards) throws Exception;
}
