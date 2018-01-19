package com.tsystems.javaschool.tasks;

public class Calculator extends CalculatorImpl {
    public static void main(String[] args) {
        CalculatorImpl c = new CalculatorImpl();
        System.out.println(c.evaluate("(1+38)*4-5")); // Result: 151
        System.out.println(c.evaluate("7*6/2+8")); // Result: 29
        System.out.println(c.evaluate("-12)1//(")); // Result: null
    }
}
