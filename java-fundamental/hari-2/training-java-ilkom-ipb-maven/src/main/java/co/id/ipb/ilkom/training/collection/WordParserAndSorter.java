/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ifnu.b.fatkhan
 */
public class WordParserAndSorter {
    
    public List<String> parseAndSort(String words){
        //check for null and empty string
        if(words == null || words.trim().length() == 0){
            //return empty array list
            return new ArrayList<>();
        }
        
        List<String> wordsSplittedAndSorted = new ArrayList<>();
        String[] wordsArray = words.split(" ");
        for (String word : wordsArray) {
//        for (int index=0; index < wordsArray.length; index++){
//            String word = wordsArray[index];
            wordsSplittedAndSorted.add(word);
        }
        //sort Collections class utility
        //using case sensitive algoritm!
        //TODO need to ignore case, how?
        //using class that implements Comparator interface
        Collections.sort(wordsSplittedAndSorted, 
                new StringIgnoreCaseComparator());
        return wordsSplittedAndSorted;
    }
    
}
