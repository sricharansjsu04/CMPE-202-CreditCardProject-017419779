package com.creditcard.factory;

import com.creditcard.fileio.IFileParser;
import com.creditcard.fileio.IFileWriter;
import com.creditcard.fileio.CSVFileParser; // assuming these classes exist
import com.creditcard.fileio.CSVFileWriter; // assuming these classes exist
import org.junit.Test;
import static org.junit.Assert.*;

public class FileOperationFactoryTest {

    @Test
    public void testCSVFileOperationFactory() {
        FileOperationFactory factory = new CSVOperationFactory(); // assuming this concrete factory exists
        IFileParser parser = factory.createFileParser();
        IFileWriter writer = factory.createFileWriter();

        assertTrue(parser instanceof CSVFileParser);
        assertTrue(writer instanceof CSVFileWriter);
    }

   

}
