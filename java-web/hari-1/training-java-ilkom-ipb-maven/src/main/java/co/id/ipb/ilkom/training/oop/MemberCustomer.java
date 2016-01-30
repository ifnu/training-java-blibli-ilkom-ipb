/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training.oop;

import co.id.ipb.ilkom.training.model.Customer;

/**
 *
 * @author ifnu.b.fatkhan
 */
public class MemberCustomer 
        extends Customer {

    private String memberId;

    @Override
    public String buy(String item) {
        return "Member " 
        + memberId
        + " with name " + getName()
        + " is buying " + item;
    }
    
    //overloading 
    public String buy(String item, Boolean freeShipping) {
        if(freeShipping){
            return this.buy(item)
            + " free shipping";
        } else {
            return super.buy(item);
        }
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(
            String memberId) {
        this.memberId = memberId;
    }
    
}
