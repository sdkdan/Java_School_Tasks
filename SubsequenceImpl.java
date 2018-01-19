package com.tsystems.javaschool.tasks;

import java.util.Arrays;

public class SubsequenceImpl extends Subsequence {
    public static void main(String[] args) {
        SubsequenceImpl s = new SubsequenceImpl();
        boolean b = s.find(Arrays.asList("A", "B", "C", "D"),
                Arrays.asList("BD", "A", "ABC", "B", "M", "D", "M","C", "DC", "D"));
        System.out.println(b); // Result: true
    }
}
