/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training.collection;

import co.id.ipb.ilkom.training.model.Customer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author ifnu.b.fatkhan
 */
public class CustomerFilter {
    //csv : comma separated value
    //customerCsv : ifnu, rijen, rizki, amar, syarif, julio, yeni, dita
    public Set<Customer> filter(String customerCsv){
        if(customerCsv == null 
                || customerCsv.trim().length() == 0){
            return Collections.emptySet();
        }
        Set<Customer> customers = new HashSet<>();
        String[] customerNames = customerCsv.split(",");
        for (String customerName : customerNames) {
            //trim to remove unwanted whitechar
            customerName = customerName.trim();
            //skip empty customerName
            if(customerName == null 
                    || customerName.length() == 0){
                continue;
            }
            Customer customer = new Customer();
            customer.setName(customerName);
            customers.add(customer);
        }
        return customers;
    }
    
    public void search(){
        
        Set<Customer> customers = new HashSet<>();
        
        //customer dengan nama ifnu
        
        Customer searchParameter = new Customer();
        searchParameter.setName("ifnu");
        //O(1)
        boolean found = customers.contains(searchParameter);
        //unique dan terurut
        Set<String> treeSet = new TreeSet<>(
                new StringIgnoreCaseComparator());
    }
    
}
