/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training.db;

import co.id.ipb.ilkom.training.model.Customer;
import co.id.ipb.ilkom.training.service.CustomerService;
import co.id.ipb.ilkom.training.service.jdbc.CustomerServiceJdbc;
import java.sql.Connection;
    import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ifnu.b.fatkhan
 */
public class CustomerServiceMysqlExample {

    public static void main(String[] args) {

        try {
            //1. Load JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");
            //2. Create Connection
            Connection connection
                    = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/trainingjava", //jdbc connection string
                            "root", //user
                            "root");//password
            
            //3. Buat dao instance
            CustomerService customerDao = new CustomerServiceJdbc(connection);
            
            Customer customer = new Customer();
            customer.setId(10);
            customer.setName("Fulan");
            customer.setEmail("fulan@email.com");
            customer.setAddress("kampus IPB");
            customer.setBirthDate(new Date());
            
//            customerDao.saveOrUpdate(customer);
//            
//            customer.setEmail("fulan.xyz@email.com");
//            customerDao.saveOrUpdate(customer);
            
            customerDao.delete(10);
            
            Customer customerWithId10 = customerDao.getCustomerById(1);
            
            List<Customer> customerFirst10Rows = customerDao.getCustomers(0, 10);
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceMysqlExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerServiceMysqlExample.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
