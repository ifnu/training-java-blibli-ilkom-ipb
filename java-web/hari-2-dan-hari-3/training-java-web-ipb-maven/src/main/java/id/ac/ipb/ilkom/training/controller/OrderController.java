/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ipb.ilkom.training.controller;

import id.ac.ipb.ilkom.training.dto.AddToCartResponse;
import id.ac.ipb.ilkom.training.model.Customer;
import id.ac.ipb.ilkom.training.model.Order;
import id.ac.ipb.ilkom.training.model.OrderItem;
import id.ac.ipb.ilkom.training.model.Product;
import id.ac.ipb.ilkom.training.service.OrderService;
import id.ac.ipb.ilkom.training.service.ProductService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ifnu.b.fatkhan
 */
@Controller
public class OrderController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/add-to-cart", method = RequestMethod.POST)
    @ResponseBody
    public AddToCartResponse addToCart(Integer productId, Integer quantity,
            HttpSession session) {
        //check if user already login or not
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            AddToCartResponse response = new AddToCartResponse();
            response.setResult(false);
            response.setErrorMessage("Please login before buy product.");
            return response;
        }
        //check product
        Product product = productService.getProduct(productId);
        if (product == null) {
            AddToCartResponse response = new AddToCartResponse();
            response.setResult(false);
            response.setErrorMessage("Product id " + productId + " is not found .");
            return response;
        }
        Order order = (Order) session.getAttribute("cart");
        if (order == null) {
            List<OrderItem> orderItems = new ArrayList<>();
            order = new Order();
            order.setOrderItems(orderItems);
        }
        boolean isProductFoundInOrderItems = false;
        for (OrderItem orderItem : order.getOrderItems()) {
            if (orderItem.getProduct().getId()
                    .equals(productId)) {
                orderItem.setQuantity(orderItem.getQuantity() + quantity);
                isProductFoundInOrderItems = true;
                break;
            }
        }
        if (!isProductFoundInOrderItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(quantity);
            orderItem.setProduct(product);
            orderItem.setPrice(product.getPrice());
            orderItem.setOrder(order); //tambahan
            order.getOrderItems().add(orderItem);
        }
        BigDecimal total = BigDecimal.ZERO;
        for (OrderItem orderItem : order.getOrderItems()) {
            BigDecimal price = orderItem.getPrice();
            BigDecimal subTotal = price.multiply(new BigDecimal(orderItem.getQuantity()));
            total = total.add(subTotal);
        }
        order.setCreatedDate(new Date());
        order.setCustomer(customer);
        order.setTotal(total);
        //check
        session.setAttribute("cart", order);
        AddToCartResponse response = new AddToCartResponse();
        response.setResult(true);
        return response;
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cart(Model model, HttpSession session) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            return "redirect:/";
        }
        return "cart";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String checkout(Model model, HttpSession session) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            return "redirect:/";
        }
        Order order = (Order) session.getAttribute("cart");
        if (order == null) {
            return "redirect:/";
        }
        orderService.save(order);
        model.addAttribute("checkout", order);
        session.setAttribute("cart", null);
        session.removeAttribute("cart");
        
        return "checkout";
    }

}
