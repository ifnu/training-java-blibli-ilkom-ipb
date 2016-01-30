/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training.oop;

/**
 *
 * @author ifnu.b.fatkhan
 */
public interface Shouter {
    //all property are publi static final
    String SHOUTER_ID = "123";
    //all method are public, and only contains declaration
    String shout(String shoutedObject);
    
}
