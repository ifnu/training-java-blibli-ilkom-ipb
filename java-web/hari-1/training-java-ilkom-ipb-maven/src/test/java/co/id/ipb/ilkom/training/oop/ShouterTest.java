/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training.oop;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ifnu.b.fatkhan
 */
public class ShouterTest {
    
    public ShouterTest() {
    }
    @Test
    public void testShout_human() {
        Human human = new Human();
        String shoutResponse = human.shout("rijen");
        Assert.assertEquals("hei rijen whatsapp?", shoutResponse);
    }
    @Test
    public void testShout_cat() {
        Cat cat = new Cat();
        String shoutResponse = cat.shout("rijen");
        Assert.assertEquals("meoonngg", shoutResponse);
    }
    @Test
    public void testShout_shouter_instantiated_with_human_class() {
        Shouter shouter = new Human();
        String shoutResponse = shouter.shout("rijen");
        Assert.assertEquals("hei rijen whatsapp?", shoutResponse);
    }
    @Test
    public void testShout_shouter_instantiated_with_cat_class() {
        Shouter shouter = new Cat();
        String shoutResponse = shouter.shout("rijen");
        Assert.assertEquals("meoonngg", shoutResponse);
    }
}
