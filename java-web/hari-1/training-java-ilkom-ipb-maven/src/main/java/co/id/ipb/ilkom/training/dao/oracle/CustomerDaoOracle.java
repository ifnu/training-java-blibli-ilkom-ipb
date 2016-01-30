/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training.dao.oracle;

import co.id.ipb.ilkom.training.dao.CustomerDao;
import co.id.ipb.ilkom.training.model.Customer;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author ifnu.b.fatkhan
 */
public class CustomerDaoOracle implements CustomerDao {

    private Connection connection;

    public CustomerDaoOracle(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Customer save(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer update(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer customerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Customer> getCustomers(Integer indexStart, Integer numOfRows) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
