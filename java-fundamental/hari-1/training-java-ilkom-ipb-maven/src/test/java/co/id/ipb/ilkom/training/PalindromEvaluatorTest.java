/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ifnu.b.fatkhan
 */
public class PalindromEvaluatorTest {
    
    public PalindromEvaluatorTest() {
    }

    @Test
    public void testIsPalindrom_one_character() {
        PalindromEvaluator evaluator = 
                new PalindromEvaluator();
        String a = "a";
        Boolean result = evaluator.isPalindrom(a);
        Assert.assertTrue(result);
    }
    
    @Test
    public void testIsPalindrom_long_character() {
        PalindromEvaluator evaluator = 
                new PalindromEvaluator();
        String aaiiuuiiaa = "aaiiuuiiaa";
        Boolean result = evaluator.isPalindrom(aaiiuuiiaa);
        Assert.assertTrue(result);
    }
    
    @Test
    public void testIsPalindrom_false_result() {
        PalindromEvaluator evaluator = 
                new PalindromEvaluator();
        String aaiiuuiiaa = "aaiiuuiia";
        Boolean result = evaluator.isPalindrom(aaiiuuiiaa);
        Assert.assertFalse(result);
    }
    
}
