/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ifnu.b.fatkhan
 */
public class ArrayExample {

    public static void main(String[] arguments) {

        for (int index = 0; index < arguments.length; index++) {
            String argument = arguments[index];
            System.out.println(
                    "argument " + index + " is " + argument);
        }
        //bubble short
        for (int i = 0; i < arguments.length; i++) {
            for (int j = i; j < arguments.length; j++) {
                String temporaryVariableToSwap;
                if (arguments[i].compareTo(arguments[j])
                        > 0) {
                    temporaryVariableToSwap = arguments[j];
                    arguments[j] = arguments[i];
                    arguments[i] = temporaryVariableToSwap;
                }
            }
        }
        System.out.println("after bubbleshort");
        for (int index = 0; index < arguments.length; index++) {
            String argument = arguments[index];
            System.out.println(
                    "argument " + index + " is " + argument);
        }
    }
}
