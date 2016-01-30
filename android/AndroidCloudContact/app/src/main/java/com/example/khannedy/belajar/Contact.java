package com.example.khannedy.belajar;

/**
 * @author Eko Kurniawan Khannedy
 */
public class Contact {

    public String id;
    public String name;
    public String email;
    public String phone;

    @Override
    public String toString() {
        return "Name : " + name + " \n" + "Email : " + email + " \n" + "Phone : " + phone;
    }
}
