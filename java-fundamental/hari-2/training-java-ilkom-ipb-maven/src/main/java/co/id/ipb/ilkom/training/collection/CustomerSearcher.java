/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training.collection;

import co.id.ipb.ilkom.training.model.Customer;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ifnu.b.fatkhan
 */
public class CustomerSearcher {
    
    public Customer searchCustomerFromCsv(String customerCsv, String customerSerched){
        if(customerCsv == null 
                || customerCsv.trim().length() == 0
                || customerSerched == null
                || customerSerched.trim().length() == 0){
            return null;
        }
        Map<String, Customer> customerMap = new HashMap<>();
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
            customerMap.put(customerName, customer);
        }
        return customerMap.get(customerSerched);
    }
    
}
