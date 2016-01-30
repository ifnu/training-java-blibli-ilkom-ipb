/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training.dao.mysql;

import co.id.ipb.ilkom.training.dao.CustomerDao;
import co.id.ipb.ilkom.training.model.Customer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ifnu.b.fatkhan
 */
public class CustomerDaoMysql implements CustomerDao {

    //create all query for each method
    private static final String INSERT_QUERY = "INSERT INTO "
            + "CUSTOMER(ID, NAME, EMAIL, ADDRESS, BIRTH_DATE) "
            + "VALUES(?,?,?,?,?)";
    private static final String UPDATE_QUERY
            = "UPDATE CUSTOMER SET NAME=?, EMAIL=?, ADDRESS=?, BIRTH_DATE=? "
            + "WHERE ID=?";
    private static final String DELETE_QUERY
            = "DELETE FROM CUSTOMER WHERE ID=?";
    private static final String SELECT_PAGING_QUERY
            = "SELECT * FROM CUSTOMER LIMIT ?,?";
    private static final String SELECT_BY_ID_QUERY
            = "SELECT * FROM CUSTOMER WHERE ID=?";
    //WARNING : not correct way to manage connection. Instead of single connection
    //please use Connection Pool. Request will be queued if only one connection available.
    //"too many connection" 
    private Connection connection;

    public CustomerDaoMysql(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Customer save(Customer customer) throws SQLException {
        PreparedStatement savePreparedStatement
                = connection.prepareStatement(INSERT_QUERY);
        savePreparedStatement.setInt(1, customer.getId());
        savePreparedStatement.setString(2, customer.getName());
        savePreparedStatement.setString(3, customer.getEmail());
        savePreparedStatement.setString(4, customer.getAddress());
        //convert from java.util.Date to java.sql.Date
        savePreparedStatement.setDate(5, new Date(customer.getBirthDate().getTime()));
        int result = savePreparedStatement.executeUpdate();
        return customer;
    }

    @Override
    public Customer update(Customer customer) throws SQLException {
        PreparedStatement updatePreparedStatement
                = connection.prepareStatement(UPDATE_QUERY);
        updatePreparedStatement.setString(1, customer.getName());
        updatePreparedStatement.setString(2, customer.getEmail());
        updatePreparedStatement.setString(3, customer.getAddress());
        updatePreparedStatement.setDate(4, new Date(customer.getBirthDate().getTime()));
        updatePreparedStatement.setInt(5, customer.getId());
        updatePreparedStatement.executeUpdate();
        return customer;
    }

    @Override
    public void delete(Integer customerId) throws SQLException {
        PreparedStatement deletePreparedStatement
                = connection.prepareStatement(DELETE_QUERY);
        deletePreparedStatement.setInt(1, customerId);
        deletePreparedStatement.executeUpdate();
    }

    @Override
    public List<Customer> getCustomers(Integer indexStart, Integer numOfRows) {
        try {
            PreparedStatement selectWithPagingPreparedStatement
                    = connection.prepareStatement(SELECT_PAGING_QUERY);
            selectWithPagingPreparedStatement.setInt(1, indexStart);
            selectWithPagingPreparedStatement.setInt(2, numOfRows);
            ResultSet customerResultSet = selectWithPagingPreparedStatement.executeQuery();
            List<Customer> customers = new ArrayList<>();
            while (customerResultSet.next()) {
                customers.add(extractCustomerFromResultSet(customerResultSet));
            }
            return customers;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.emptyList();
    }

    public Customer extractCustomerFromResultSet(ResultSet customerResultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setId(customerResultSet.getInt("ID"));
        customer.setName(customerResultSet.getString("NAME"));
        customer.setEmail(customerResultSet.getString("EMAIL"));
        customer.setAddress(customerResultSet.getString("ADDRESS"));
        Date birthDate = customerResultSet.getDate("BIRTH_DATE");
        customer.setBirthDate(new java.util.Date(birthDate.getTime()));
        return customer;
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        try {
            PreparedStatement selectByIdPreparedStatement
                    = connection.prepareStatement(SELECT_BY_ID_QUERY);
            selectByIdPreparedStatement.setInt(1, customerId);
            ResultSet customerResultSet = selectByIdPreparedStatement.executeQuery();
            //get only one row using if instead of using while
            if (customerResultSet.next()) {
                return extractCustomerFromResultSet(customerResultSet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
