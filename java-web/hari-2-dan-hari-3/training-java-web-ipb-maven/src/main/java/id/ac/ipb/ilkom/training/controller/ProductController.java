/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ipb.ilkom.training.controller;

import id.ac.ipb.ilkom.training.model.Product;
import id.ac.ipb.ilkom.training.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ifnu.b.fatkhan
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/{productName}-{id}", method = RequestMethod.GET)
    public String productDetail(
            @PathVariable(value = "productName") String productName,
            @PathVariable(value = "id") String id,
            Model model) {

        Product product = productService.getProduct(Integer.valueOf(id));
        model.addAttribute("product", product);
        return "product";
    }

}
