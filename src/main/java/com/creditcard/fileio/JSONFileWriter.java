package com.creditcard.fileio;

import com.creditcard.util.CreditCardWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.io.File;

public class JSONFileWriter implements IFileWriter {
    
    @Override
    public void writeCreditCards(String filePath, List<CreditCardWrapper> creditCards) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(filePath), creditCards);
    }
}
