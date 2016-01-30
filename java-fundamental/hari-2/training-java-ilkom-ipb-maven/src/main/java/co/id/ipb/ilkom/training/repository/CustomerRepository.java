/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training.repository;

import co.id.ipb.ilkom.training.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ifnu.b.fatkhan
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
