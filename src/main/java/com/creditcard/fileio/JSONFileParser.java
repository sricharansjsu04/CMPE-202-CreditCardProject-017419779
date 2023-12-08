package com.creditcard.fileio;

import com.creditcard.util.CreditCardDeserializer;
import com.creditcard.util.CreditCardWrapper;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.util.List;

public class JSONFileParser implements IFileParser {
    
    @Override
    public List<CreditCardWrapper> parseCreditCards(String filePath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(CreditCardWrapper.class, new CreditCardDeserializer());
        mapper.registerModule(module);

        JavaType type = TypeFactory.defaultInstance().constructCollectionType(List.class, CreditCardWrapper.class);
        List<CreditCardWrapper> creditCards = mapper.readValue(new File(filePath), type);

        
        return creditCards;
    }
}
