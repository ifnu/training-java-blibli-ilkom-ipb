/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ipb.ilkom.training.repository;

import id.ac.ipb.ilkom.training.model.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ifnu.b.fatkhan
 */
public interface OrderRepository 
        extends JpaRepository<Order, Integer> {

    @Query("select o from Order o "
            + "left join fetch o.orderItems "
            + "left join fetch o.customer "
            + "where o.customer.id=:id")
    List<Order> findOrderByCustomer(
            @Param("id") Integer customerId);
    
}
