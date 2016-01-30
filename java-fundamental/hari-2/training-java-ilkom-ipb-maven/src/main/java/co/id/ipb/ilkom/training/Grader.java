/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training;

/**
 *
 * @author ifnu.b.fatkhan
 */
public class Grader {
    public String grade(Integer mark){
        if (mark < 0 || mark > 100) {
            return null;
        } else if (mark >= 0 && mark < 30) {
            return "E";
        } else if (mark >= 30 && mark < 50) {
            return "D";
        } else if (mark >= 50 && mark < 70) {
            return "C";
        } else if (mark >= 70 && mark < 85) {
            return "B";
        } else {
            return "A";
        }
    }
    
    
}
