/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training.db;

import co.id.ipb.ilkom.training.model.Customer;
import co.id.ipb.ilkom.training.service.CustomerService;
import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author ifnu.b.fatkhan
 */
public class CustomerServiceJpaExample {

    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(SpringDataJpaConfiguration.class);
        CustomerService customerService
                = applicationContext.getBean(CustomerService.class);
        Customer customer = new Customer();
        customer.setId(10);
        customer.setName("Fulan");
        customer.setEmail("fulan@email.com");
        customer.setAddress("kampus IPB");
        customer.setBirthDate(new Date());
        customerService.saveOrUpdate(customer);
    }
}
