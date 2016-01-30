/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training.service.jpa;

import co.id.ipb.ilkom.training.model.Customer;
import co.id.ipb.ilkom.training.repository.CustomerRepository;
import co.id.ipb.ilkom.training.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ifnu.b.fatkhan
 */
@Service
@Transactional(readOnly = true)
public class CustomerServiceJpa implements CustomerService{
    
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional(readOnly = false)
    public Customer saveOrUpdate(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public void delete(Integer customerId) {
        customerRepository.delete(customerId);
    }

    @Override
    public List<Customer> getCustomers(Integer indexStart, Integer numOfRows) {
        int page = indexStart / numOfRows;
        PageRequest pageRequest = new PageRequest(page, numOfRows);
        Page<Customer> customers = customerRepository.findAll(pageRequest);
        return customers.getContent();
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        return customerRepository.findOne(customerId);
    }
    
}
