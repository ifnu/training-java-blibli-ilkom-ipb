/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ipb.ilkom.training.controller;

import id.ac.ipb.ilkom.training.model.Product;
import id.ac.ipb.ilkom.training.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ifnu.b.fatkhan
 */
@Controller
public class HomeController {

    @Autowired
    private ProductService productService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        
        List<Product> products = 
                productService.getProducts(0, 24);
        model.addAttribute("products", products);
        
        return "home";
    }

}
