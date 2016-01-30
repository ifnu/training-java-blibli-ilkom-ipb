/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training.dao;

import co.id.ipb.ilkom.training.model.Customer;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ifnu.b.fatkhan
 */
public interface CustomerDao {
    
    //CRUD
    
    Customer save(Customer customer) throws SQLException;
    
    Customer update(Customer customer) throws SQLException;
    
    void delete(Integer customerId) throws SQLException;
    
    List<Customer> getCustomers(Integer indexStart, Integer numOfRows);
    
    Customer getCustomerById(Integer customerId);
    
    //Customer getCustomerByEmail(String email);
    
}
