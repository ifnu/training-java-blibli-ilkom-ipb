/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training.service;

import co.id.ipb.ilkom.training.model.Customer;
import java.util.List;

/**
 *
 * @author ifnu.b.fatkhan
 */
public interface CustomerService {

    Customer saveOrUpdate(Customer customer);
    
    void delete(Integer customerId);
    
    List<Customer> getCustomers(Integer indexStart, Integer numOfRows);
    
    Customer getCustomerById(Integer customerId);

}
