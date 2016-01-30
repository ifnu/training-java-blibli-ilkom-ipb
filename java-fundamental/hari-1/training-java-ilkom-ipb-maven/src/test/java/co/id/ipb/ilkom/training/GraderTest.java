/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ipb.ilkom.training;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ifnu.b.fatkhan
 */
public class GraderTest {

    public GraderTest() {
    }

    @Test
    public void testGrade_minus() {
        Grader grader = new Grader();
        int mark = -10;
        String grade = grader.grade(mark);
        Assert.assertNull(grade);
    }

    @Test
    public void testGrade_one_hundred() {
        Grader grader = new Grader();
        int mark = 100;
        String grade = grader.grade(mark);
        Assert.assertEquals("A", grade);
    }

    @Test
    public void testGrade_seventy_five() {
        Grader grader = new Grader();
        int mark = 75;
        String grade = grader.grade(mark);
        Assert.assertEquals("B", grade);
    }

    @Test
    public void testGrade_sixty_five() {
        Grader grader = new Grader();
        int mark = 65;
        String grade = grader.grade(mark);
        Assert.assertEquals("C", grade);
    }

    @Test
    public void testGrade_fourty_five() {
        Grader grader = new Grader();
        int mark = 45;
        String grade = grader.grade(mark);
        Assert.assertEquals("D", grade);
    }

    @Test
    public void testGrade_five() {
        Grader grader = new Grader();
        int mark = 5;
        String grade = grader.grade(mark);
        Assert.assertEquals("E", grade);
    }

}
