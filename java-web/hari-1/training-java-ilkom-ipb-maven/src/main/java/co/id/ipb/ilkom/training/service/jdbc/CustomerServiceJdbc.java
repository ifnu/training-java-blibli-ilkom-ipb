/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training.service.jdbc;

import co.id.ipb.ilkom.training.dao.CustomerDao;
import co.id.ipb.ilkom.training.dao.mysql.CustomerDaoMysql;
import co.id.ipb.ilkom.training.model.Customer;
import co.id.ipb.ilkom.training.service.CustomerService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ifnu.b.fatkhan
 */
public class CustomerServiceJdbc implements CustomerService {

    private CustomerDao customerDao;
    private Connection connection;

    public CustomerServiceJdbc(Connection connection) {
        this.connection = connection;
        this.customerDao = new CustomerDaoMysql(connection);
    }

    @Override
    public Customer saveOrUpdate(Customer customer) {
        try {
            connection.setAutoCommit(false);
            Customer customerFromDb = null;
            if (customer.getId() != null) {
                customerFromDb = customerDao.getCustomerById(customer.getId());
            }
            if (customerFromDb != null) {
                customerDao.update(customer);
            } else {
                customerDao.save(customer);
            }
            connection.commit();
            return customer;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceJdbc.class.getName()).log(Level.SEVERE, null, ex);
            try {
                //try to rollback if needed
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(CustomerServiceJdbc.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(CustomerServiceJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public void delete(Integer customerId) {
        try {
            connection.setAutoCommit(false);
            customerDao.delete(customerId);
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceJdbc.class.getName()).log(Level.SEVERE, null, ex);
            try {
                //try to rollback if needed
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(CustomerServiceJdbc.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(CustomerServiceJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Customer> getCustomers(Integer indexStart, Integer numOfRows) {
        return customerDao.getCustomers(indexStart, numOfRows);
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        return customerDao.getCustomerById(customerId);
    }

}
