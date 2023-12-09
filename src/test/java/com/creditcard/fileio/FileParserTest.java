package com.creditcard.fileio;

import com.creditcard.util.CreditCardWrapper;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class FileParserTest {

    @Test
    public void testCSVFileParser() throws Exception {
        IFileParser parser = new CSVFileParser(); 
        String filePath = "src/creditcards.csv"; 

        List<CreditCardWrapper> creditCards = parser.parseCreditCards(filePath);
        assertNotNull(creditCards);
        assertFalse(creditCards.isEmpty());

        
    }

    @Test(expected = Exception.class)
    public void testCSVFileParserWithInvalidFile() throws Exception {
        IFileParser parser = new CSVFileParser();
        String filePath = "path/to/nonexistent/file.csv";

        parser.parseCreditCards(filePath); 
    }

    
}
