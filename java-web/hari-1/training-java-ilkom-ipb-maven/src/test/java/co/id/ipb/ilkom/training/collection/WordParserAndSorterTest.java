/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training.collection;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ifnu.b.fatkhan
 */
public class WordParserAndSorterTest {
    
    public WordParserAndSorterTest() {
    }

    @Test
    public void testParseAndSort_null() {
        WordParserAndSorter wordParserAndSorter
                = new WordParserAndSorter();
        List<String> result = wordParserAndSorter.parseAndSort(null);
        Assert.assertNotNull(result);
        Assert.assertEquals(0, result.size());
    }
    @Test
    public void testParseAndSort_empty_string() {
        WordParserAndSorter wordParserAndSorter
                = new WordParserAndSorter();
        List<String> result = wordParserAndSorter.parseAndSort("");
        Assert.assertNotNull(result);
        Assert.assertEquals(0, result.size());
    }
    @Test
    public void testParseAndSort_whitechar() {
        WordParserAndSorter wordParserAndSorter
                = new WordParserAndSorter();
        List<String> result = 
                wordParserAndSorter.parseAndSort(" \n \t");
        Assert.assertNotNull(result);
        Assert.assertEquals(0, result.size());
    }
    @Test
    public void testParseAndSort_words() {
        WordParserAndSorter wordParserAndSorter
                = new WordParserAndSorter();
        List<String> result = 
                wordParserAndSorter.parseAndSort(
                        "Saya sedang training java di ilkom ipb");
        Assert.assertNotNull(result);
        Assert.assertEquals(7, result.size());
        String[] expectedResult = {"di","ilkom","ipb",
            "java","Saya","sedang", "training"};
        String[] resultArray = new String[result.size()];
        result.toArray(resultArray);
        Assert.assertArrayEquals(expectedResult, resultArray);
    }
    
}
