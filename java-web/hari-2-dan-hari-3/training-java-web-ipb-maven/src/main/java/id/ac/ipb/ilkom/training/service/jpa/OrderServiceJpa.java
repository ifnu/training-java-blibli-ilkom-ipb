/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ipb.ilkom.training.service.jpa;

import id.ac.ipb.ilkom.training.model.Customer;
import id.ac.ipb.ilkom.training.model.Order;
import id.ac.ipb.ilkom.training.repository.OrderRepository;
import id.ac.ipb.ilkom.training.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ifnu.b.fatkhan
 */
@Service
@Transactional(readOnly = true)
public class OrderServiceJpa implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional(readOnly = false)
    public Order save(Order order) {
        orderRepository.save(order);
        return order;
    }

    @Override
    public List<Order> getOrderByCustomer(
            Customer customer) {
        return orderRepository.findOrderByCustomer(
                customer.getId());
    }

}
