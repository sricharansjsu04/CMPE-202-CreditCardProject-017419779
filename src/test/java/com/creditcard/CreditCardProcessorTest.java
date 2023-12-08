package com.creditcard;

import org.junit.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreditCardProcessorTest {

    private static final String CSV_INPUT_FILE = "src/creditcards.csv";
    private static final String CSV_OUTPUT_FILE = "src/output.csv";
    private static final String JSON_INPUT_FILE = "src/creditcards.json";
    private static final String JSON_OUTPUT_FILE = "src/output.json";
    private static final String XML_INPUT_FILE = "src/creditcards.xml";
    private static final String XML_OUTPUT_FILE = "src/output.xml";

    
  
    @BeforeClass
    public static void setUp() {
        // Prepare test data if necessary
    }

    @Test
    public void testProcessCSVFile() throws Exception {
        CreditCardProcessor.processFile(CSV_INPUT_FILE, CSV_OUTPUT_FILE);
        Assert.assertTrue(Files.exists(Paths.get(CSV_OUTPUT_FILE)));
        // Further assertions to check the file content
    }

    @Test
    public void testProcessJSONFile() throws Exception {
        CreditCardProcessor.processFile(JSON_INPUT_FILE, JSON_OUTPUT_FILE);
        Assert.assertTrue(Files.exists(Paths.get(JSON_OUTPUT_FILE)));
        // Further assertions to check the file content
    }

    @Test
    public void testProcessXMLFile() throws Exception {
        CreditCardProcessor.processFile(XML_INPUT_FILE, XML_OUTPUT_FILE);
        Assert.assertTrue(Files.exists(Paths.get(XML_OUTPUT_FILE)));
        // Further assertions to check the file content
    }



    @AfterClass
    public static void tearDown() {
        // Perform any cleanup for the entire test class after all tests have run
    }
    
}
