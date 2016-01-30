/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training.oop;

import co.id.ipb.ilkom.training.model.Customer;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ifnu.b.fatkhan
 */
public class MemberCustomerTest {

    public MemberCustomerTest() {
    }

    @Test
    public void testBuy_customer() {
        Customer customer = new Customer();
        customer.setName("rijen");
        String buyResult = customer.buy("book");
        Assert.assertEquals("Customer rijen is buying book",
                buyResult);
    }

    @Test
    public void testBuy_member() {
        MemberCustomer member = new MemberCustomer();
        member.setMemberId("123"); //specific behavior to MemberCustomer
        member.setName("rijen"); //inheritance from Customer
        String buyResult = member.buy("book"); //same buy method but different implementation
        Assert.assertEquals("Member 123 with name rijen is buying book",
                buyResult);
    }

    @Test
    public void testBuy_customer_instatiated_using_member() {
        Customer customer = new MemberCustomer();
        customer.setName("rijen");
        String buyResult = customer.buy("book");
        Assert.assertEquals("Member null with name rijen is buying book",
                buyResult);
    }

    @Test
    public void testBuy_customer_instatiated_using_member_casting() {
        Customer customer = new MemberCustomer();
        customer.setName("rijen");
        if (customer instanceof MemberCustomer) {
            MemberCustomer member = (MemberCustomer) customer;
            member.setMemberId("123");
            //short hand syntax
            ((MemberCustomer) customer).setMemberId("123");
        }
        String buyResult = customer.buy("book");
        Assert.assertEquals("Member 123 with name rijen is buying book",
                buyResult);
    }

}
