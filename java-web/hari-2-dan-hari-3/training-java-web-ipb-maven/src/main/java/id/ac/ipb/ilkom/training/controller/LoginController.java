/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ipb.ilkom.training.controller;

import id.ac.ipb.ilkom.training.model.Customer;
import id.ac.ipb.ilkom.training.service.CustomerService;
import javax.servlet.http.HttpSession;
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
public class LoginController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpSession session, Model model) {
        String errorMessage = (String) session.getAttribute("errorMessage");
        if(errorMessage != null 
                && errorMessage.trim().length() > 0){
            model.addAttribute("errorMessage", errorMessage);
            //remove attribute from session
            session.setAttribute("errorMessage", null);
            session.removeAttribute("errorMessage");
        }
        return "login";
    }

    @RequestMapping(value = "/process-login", method = RequestMethod.POST)
    public String processLogin(
            String userName,
            String password,
            HttpSession session) {

        //process username and password sent from login form
        Customer customer = customerService.getCustomerByEmail(userName);
        if (customer != null) {

            //if successfull, create session to indicate user already login
            session.setAttribute("userName", userName);
            session.setAttribute("customer", customer);
            //redirect to homepage
            return "redirect:/";
        } else {
            session.setAttribute("errorMessage",
                    "User " + userName
                    + " tidak ditemukan atau password salah");
            return "redirect:/login";
        }

    }

}
