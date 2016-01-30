/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ipb.ilkom.training.service;

import id.ac.ipb.ilkom.training.model.Product;
import java.util.List;

/**
 *
 * @author ifnu.b.fatkhan
 */
public interface ProductService {
    
    Product getProduct(Integer id);
    
    List<Product> getProducts(Integer i, Integer numOfRows);
    
}
