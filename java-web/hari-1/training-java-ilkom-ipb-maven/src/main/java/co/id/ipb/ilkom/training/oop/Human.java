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
public class Human implements Shouter {

    @Override
    public String shout(
            String shoutedObject) {
        return "hei " + shoutedObject
                + " whatsapp?";
    }

}
