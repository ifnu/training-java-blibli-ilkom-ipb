/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training.collection;

import java.util.Comparator;

/**
 *
 * @author ifnu.b.fatkhan
 */
public class StringIgnoreCaseComparator
        implements Comparator<String> {

    @Override
    public int compare(String o1, 
            String o2) {
        return o1.toLowerCase().compareTo(o2.toLowerCase());
    }

}
