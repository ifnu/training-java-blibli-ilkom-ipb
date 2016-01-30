/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ipb.ilkom.training.repository;

import id.ac.ipb.ilkom.training.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ifnu.b.fatkhan
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}
