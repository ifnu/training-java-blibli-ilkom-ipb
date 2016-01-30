/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ipb.ilkom.training.service.jpa;

import id.ac.ipb.ilkom.training.model.Product;
import id.ac.ipb.ilkom.training.repository.ProductRepository;
import id.ac.ipb.ilkom.training.service.ProductService;
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
public class ProductServiceJpa implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public Product getProduct(Integer id) {
        return productRepository.findOne(id);
    }

    @Override
    public List<Product> getProducts(Integer indexStart, Integer numOfRows) {
                int page = indexStart / numOfRows;
        PageRequest pageRequest = new PageRequest(page, numOfRows);
        Page<Product> products = productRepository.findAll(pageRequest);
        return products.getContent();

    }
    
}
