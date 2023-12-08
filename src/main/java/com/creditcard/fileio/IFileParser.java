package com.creditcard.fileio;

import java.util.List;

import com.creditcard.util.CreditCardWrapper;

public interface IFileParser {
    List<CreditCardWrapper> parseCreditCards(String filePath) throws Exception;
}
