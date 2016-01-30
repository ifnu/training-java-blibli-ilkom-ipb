/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training.dao.mysql;

import co.id.ipb.ilkom.training.dao.CustomerDao;
import co.id.ipb.ilkom.training.model.Customer;
import co.id.ipb.ilkom.training.util.DatabaseTest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 * @author ifnu.b.fatkhan
 */
public class CustomerDaoMysqlTest extends DatabaseTest{

    @Test
    public void testSave() {
        try {
            CustomerDao customerDao = new CustomerDaoMysql(connection);
            Customer customer = new Customer();
            customer.setId(10);
            customer.setName("Fulan");
            customer.setEmail("fulan@email.com");
            customer.setAddress("kampus IPB");
            customer.setBirthDate(new Date());
            customerDao.save(customer);
            String rowCountQuery = "SELECT COUNT(*) AS ROW_COUNT FROM CUSTOMER";
            ResultSet rowCountResultSet = connection.createStatement()
                    .executeQuery(rowCountQuery);
            if (rowCountResultSet.next()) {
                Integer result = rowCountResultSet.getInt("ROW_COUNT");
                Integer expectedRowCount = 5;
                Assert.assertEquals(expectedRowCount, result);
            } else {
                Assert.fail("cannot find row count");
            }
        } catch (SQLException ex) {
            Assert.fail("error exception " + ex.getMessage());
            Logger.getLogger(CustomerDaoMysqlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testUpdate() {
        try {
            CustomerDao customerDao = new CustomerDaoMysql(connection);
            Customer customer = new Customer();
            customer.setId(1);
            customer.setEmail("updated@email.com");
            customer.setName("updated");
            customer.setAddress("updated address");
            Date updatedBirthDate = new GregorianCalendar(1990, 10, 10).getTime();
            customer.setBirthDate(updatedBirthDate);
            customerDao.update(customer);
            String rowCountQuery = "SELECT * FROM CUSTOMER WHERE ID=1";
            ResultSet custiomerWithId1ResultSet = connection.createStatement()
                    .executeQuery(rowCountQuery);
            if (custiomerWithId1ResultSet.next()) {
                String name = custiomerWithId1ResultSet.getString("NAME");
                Assert.assertEquals("updated", name);
                String email = custiomerWithId1ResultSet.getString("EMAIL");
                Assert.assertEquals("updated@email.com", email);
                String address = custiomerWithId1ResultSet.getString("ADDRESS");
                Assert.assertEquals("updated address", address);
                Date birthDate = custiomerWithId1ResultSet.getDate("BIRTH_DATE");
                Assert.assertEquals(updatedBirthDate, birthDate);
            } else {
                Assert.fail("cannot find row count");
            }
        } catch (SQLException ex) {
            Assert.fail("error exception " + ex.getMessage());
            Logger.getLogger(CustomerDaoMysqlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testDelete() {
        try {
            CustomerDao customerDao = new CustomerDaoMysql(connection);
            customerDao.delete(1);
            String rowCountQuery = "SELECT COUNT(*) AS ROW_COUNT FROM CUSTOMER";
            ResultSet rowCountResultSet = connection.createStatement()
                    .executeQuery(rowCountQuery);
            if (rowCountResultSet.next()) {
                Integer result = rowCountResultSet.getInt("ROW_COUNT");
                Integer expectedRowCount = 3;
                Assert.assertEquals(expectedRowCount, result);
            } else {
                Assert.fail("cannot find row count");
            }
        } catch (SQLException ex) {
            Assert.fail("error exception " + ex.getMessage());
            Logger.getLogger(CustomerDaoMysqlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testGetCustomers() {
        CustomerDao customerDao = new CustomerDaoMysql(connection);
        List<Customer> customers = customerDao.getCustomers(0, 10);
        Assert.assertEquals(4, customers.size());
    }

    @Test
    public void testExtractCustomerFromResultSet() {
        try {
            //mock Mockito
            ResultSet mockCustomerResultSet
                    = Mockito.mock(ResultSet.class);
            Mockito.when(mockCustomerResultSet.getInt("ID")).thenReturn(1);
            Mockito.when(mockCustomerResultSet.getString("NAME")).thenReturn("Fulan");
            Mockito.when(mockCustomerResultSet.getString("EMAIL")).thenReturn("fulan@email.com");
            Mockito.when(mockCustomerResultSet.getString("ADDRESS")).thenReturn("kampus ipb");
            //GregorianCalendar month is started from 0 not 1!! 10 meant november.
            java.sql.Date birthDate = new java.sql.Date(new GregorianCalendar(1990, 10, 1).getTimeInMillis());
            Mockito.when(mockCustomerResultSet.getDate("BIRTH_DATE")).thenReturn(birthDate);
            
            CustomerDaoMysql customerDao = new CustomerDaoMysql(connection);
            
            Customer customer = customerDao.extractCustomerFromResultSet(mockCustomerResultSet);
            Assert.assertEquals(new Integer(1), customer.getId());
            Assert.assertEquals("Fulan", customer.getName());
            Assert.assertEquals("fulan@email.com", customer.getEmail());
            Assert.assertEquals("kampus ipb", customer.getAddress());
            Assert.assertEquals(new Date(birthDate.getTime()), customer.getBirthDate());
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoMysqlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testGetCustomerById() {
        CustomerDao customerDao = new CustomerDaoMysql(connection);
        Customer customer = customerDao.getCustomerById(1);
        Assert.assertNotNull(customer);
        Assert.assertEquals(new Integer(1), customer.getId());
        Assert.assertEquals("Fulan", customer.getName());
        Assert.assertEquals("fulan@email.com", customer.getEmail());
        Assert.assertEquals("kampus ipb", customer.getAddress());
        //GregorianCalendar month is started from 0 not 1!! 10 meant november.
        Date updatedBirthDate = new GregorianCalendar(1990, 10, 1).getTime();
        Assert.assertEquals(updatedBirthDate, customer.getBirthDate());
    }

}
