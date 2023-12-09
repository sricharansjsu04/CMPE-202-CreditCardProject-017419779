package com.creditcard.fileio;

import com.creditcard.util.CreditCardWrapper;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileWriterTest {

    @Test
    public void testCSVFileWriter() throws Exception {
        IFileWriter writer = new CSVFileWriter(); 
        String filePath = "src/testout.csv";
        List<CreditCardWrapper> creditCards = new ArrayList<>(); 

        writer.writeCreditCards(filePath, creditCards);

        File file = new File(filePath);
        assertTrue(file.exists());
        assertTrue(file.length() > 0);


        file.delete();
    }


}
