/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ipb.ilkom.training.servlet;

import id.ac.ipb.ilkom.training.model.Customer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ifnu.b.fatkhan
 */
@WebServlet(name = "CustomerList", urlPatterns = {"/customer-list"})
public class CustomerList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //create dummy data for Customer List
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            Customer customer = new Customer();
            customer.setId(i);
            customer.setName("name " + i);
            customer.setEmail("email" + i + "@email.com");
            customer.setBirthDate(new Date());
            customer.setAddress("address " + i);
            customers.add(customer);
        }
        request.setAttribute("customers", customers);
           
        //forward data set in request.setAttribute to JSP 
        String viewJspFile = "/WEB-INF/views/customer-list.jsp";
        RequestDispatcher dispatcher = 
                getServletContext().getRequestDispatcher(viewJspFile);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
