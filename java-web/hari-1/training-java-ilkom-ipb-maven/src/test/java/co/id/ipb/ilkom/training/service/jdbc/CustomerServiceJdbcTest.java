/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training.service.jdbc;

import co.id.ipb.ilkom.training.dao.mysql.CustomerDaoMysqlTest;
import co.id.ipb.ilkom.training.model.Customer;
import co.id.ipb.ilkom.training.service.CustomerService;
import co.id.ipb.ilkom.training.util.DatabaseTest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ifnu.b.fatkhan
 */
public class CustomerServiceJdbcTest extends DatabaseTest {


    @Test
    public void testSaveOrUpdate_save() {
        try {
            CustomerService customerService = new CustomerServiceJdbc(connection); 
            Customer customer = new Customer();
            customer.setId(10);
            customer.setName("Fulan");
            customer.setEmail("fulan@email.com");
            customer.setAddress("kampus IPB");
            customer.setBirthDate(new Date());
            customerService.saveOrUpdate(customer);
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
    public void testSaveOrUpdate_update() {
        try {
            CustomerService customerService = new CustomerServiceJdbc(connection);
            Customer customer = new Customer();
            customer.setId(1);
            customer.setEmail("updated@email.com");
            customer.setName("updated");
            customer.setAddress("updated address");
            Date updatedBirthDate = new GregorianCalendar(1990, 10, 10).getTime();
            customer.setBirthDate(updatedBirthDate);
            customerService.saveOrUpdate(customer);
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
        //skip since the code exactly the same as DAO
    }

    @Test
    public void testGetCustomers() {
        //skip since the code exactly the same as DAO
    }

    @Test
    public void testGetCustomerById() {
        //skip since the code exactly the same as DAO
    }

}
