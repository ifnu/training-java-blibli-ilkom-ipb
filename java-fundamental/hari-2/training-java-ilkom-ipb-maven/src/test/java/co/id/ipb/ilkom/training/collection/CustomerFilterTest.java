/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training.collection;

import co.id.ipb.ilkom.training.model.Customer;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ifnu.b.fatkhan
 */
public class CustomerFilterTest {
    
    public CustomerFilterTest() {
    }

    @Test
    public void testFilter_null() {
        CustomerFilter customerFilter = new CustomerFilter();
        Set<Customer> result = customerFilter.filter(null);
        Assert.assertNotNull(result);
        Assert.assertEquals(0, result.size());
    }
    
    @Test
    public void testFilter_empty() {
        CustomerFilter customerFilter = new CustomerFilter();
        Set<Customer> result = customerFilter.filter("");
        Assert.assertNotNull(result);
        Assert.assertEquals(0, result.size());
    }
    
    @Test
    public void testFilter_whitechar() {
        CustomerFilter customerFilter = new CustomerFilter();
        Set<Customer> result = customerFilter.filter("   \n\t");
        Assert.assertNotNull(result);
        Assert.assertEquals(0, result.size());
    }
    
    @Test
    public void testFilter_unique_input(){
        CustomerFilter customerFilter = new CustomerFilter();
        String input = "rizki, uray";
        Set<Customer> result = customerFilter.filter(input);
        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.size());
    }
    
    @Test
    public void testFilter_nonunique_input(){
        CustomerFilter customerFilter = new CustomerFilter();
        String input = "rizki, uray, rizki";
        Set<Customer> result = customerFilter.filter(input);
        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.size());
    }
    @Test
    public void testFilter_nonunique_input_with_whitechar(){
        CustomerFilter customerFilter = new CustomerFilter();
        String input = ", rizki, uray, , rizki, \n\t";
        Set<Customer> result = customerFilter.filter(input);
        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.size());
    }
    
}
