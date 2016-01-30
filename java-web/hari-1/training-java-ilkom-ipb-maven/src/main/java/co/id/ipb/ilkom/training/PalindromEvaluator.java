/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training;

/**
 *
 * @author ifnu.b.fatkhan
 */
public class PalindromEvaluator {

    public boolean isPalindrom(String text) {
        String result = "";
        char[] arrayOfChars = text.toCharArray();

        for (char c : arrayOfChars) {
            result = c + result;
        }
        return text.toLowerCase().equals(
                result.toLowerCase());
    }

}
